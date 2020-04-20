package Part_11;

import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.TransferQueue;

/**
 * transfer 方法的逻辑是：
 * 如果当前有消费者正在等待接收元素，通过 transfer 方法可以把生产者传入的元素立刻传输给消费者。
 * 如果没有消费者在等待接收元素，则 transfer 方法会将元素存放在队列的 tail 节点，并等到该元素被消费者消费了才返回。
 *
 * 整体逻辑：先看线程 2，再看线程 1
 */
public class TransferQueueTest {

    public static void main(String[] args) {
        char[] c1 = "1234567".toCharArray();
        char[] c2 = "ABCDEFG".toCharArray();

        TransferQueue<Character> queue = new LinkedTransferQueue<>();

        new Thread(() -> {
            try {
                for (char c : c1) {
                    System.out.print(queue.take());
                    queue.transfer(c);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "t1").start();

        new Thread(() -> {
            try {
                for (char c : c2) {
                    // transfer 是阻塞操作
                    queue.transfer(c);
                    System.out.print(queue.take());
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "t2").start();
    }
}
