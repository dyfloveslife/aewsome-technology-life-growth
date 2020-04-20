package Part_11;

import java.util.concurrent.locks.LockSupport;

/**
 * 在当前线程还阻塞的情况下唤醒该线程，当该线一旦阻塞的时候发现，已经有线程唤醒过它了，
 * 则就不会阻塞了。
 *
 * 1. 由于先输出 1，所以需要在线程 2 中首先进行 park 操作，让线程 2 阻塞；
 * 2. 其次线程 1 输出 1，再执行 unPark(t2) 操作唤醒线程 2，然后执行 park 阻塞自己；
 * 3. 然后线程 2 输出 A，再执行 unPark(t1) 操作唤醒线程 1，然后执行 park 阻塞自己；
 * 4. 不断重复.....
 */
public class LockSupportTest {

    static Thread t1 = null, t2 = null;

    public static void main(String[] args) {
        char[] c1 = "1234567".toCharArray();
        char[] c2 = "ABCDEFG".toCharArray();

        t1 = new Thread(() -> {
            for (char c : c1) {
                System.out.print(c);
                // 叫醒 t2
                LockSupport.unpark(t2);
                // 阻塞 t1
                LockSupport.park();
            }
        }, "t1");

        t2 = new Thread(() -> {
            for (char c : c2) {
                // 阻塞 t2
                LockSupport.park();
                System.out.print(c);
                // 叫醒 t1
                LockSupport.unpark(t1);
            }
        }, "t2");

        t1.start();
        t2.start();
    }
}
