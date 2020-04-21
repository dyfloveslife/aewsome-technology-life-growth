package Part_13;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchTest {

    private static CountDownLatch latch = new CountDownLatch(2);

    public static void main(String[] args) throws InterruptedException {

        new Thread(() -> {
            try {
                System.out.println("子线程 " + Thread.currentThread().getName() + " 正在执行...");
                Thread.sleep(3000);
                System.out.println("子线程 " + Thread.currentThread().getName() + " 执行完毕...");

                latch.countDown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "t1").start();

        new Thread(() -> {
            try {
                System.out.println("子线程 " + Thread.currentThread().getName() + " 正在执行...");
                Thread.sleep(3000);
                System.out.println("子线程 " + Thread.currentThread().getName() + " 执行完毕...");

                latch.countDown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "t2").start();

        System.out.println("等待两个子线程执行完毕...");
        latch.await();
        System.out.println("两个子线程已经执行完毕...");
        System.out.println("继续执行主线程 main...");
    }
}
