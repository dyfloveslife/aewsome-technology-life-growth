package Part_13;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierTest_01 {

    static CyclicBarrier cb = new CyclicBarrier(2);

    public static void main(String[] args) {
        new Thread(() -> {
            System.out.println("线程 " + Thread.currentThread().getName() + " 准备阻塞...");
            try {
                cb.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
            System.out.println("线程 " + Thread.currentThread().getName() + " 执行完毕...");
        }, "t1").start();

        System.out.println("线程 " + Thread.currentThread().getName() + " 准备阻塞...");
        try {
            cb.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
        System.out.println("线程 " + Thread.currentThread().getName() + " 执行完毕...");
    }
}
