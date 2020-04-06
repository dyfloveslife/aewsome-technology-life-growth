package Part_04;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockInterruptiblyTest {
    private Lock lock = new ReentrantLock();

    public static void main(String[] args) {
        LockInterruptiblyTest test = new LockInterruptiblyTest();

        MyThreadDemo thread1 = new MyThreadDemo(test, "A");
        MyThreadDemo thread2 = new MyThreadDemo(test, "B");

        thread1.start();
        thread2.start();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread2.interrupt();
    }

    public void insert(Thread thread) throws InterruptedException {
        lock.lockInterruptibly();
        try {
            System.out.println("线程 " + thread.getName() + " 得到了锁...");
            long startTime = System.currentTimeMillis();
            for (; ; ) {
                if (System.currentTimeMillis() - startTime >= Integer.MAX_VALUE) {
                    break;
                }
            }
        } finally {
            System.out.println(Thread.currentThread().getName() + " 执行 finally...");
            lock.unlock();
            System.out.println("线程 " + thread.getName() + " 释放了锁...");
        }
        System.out.println("执行完毕...");
    }
}


class MyThreadDemo extends Thread {
    private LockInterruptiblyTest test = null;

    public MyThreadDemo(LockInterruptiblyTest test, String name) {
        super(name);
        this.test = test;
    }

    @Override
    public void run() {
        try {
            test.insert(Thread.currentThread());
        } catch (InterruptedException e) {
            System.out.println("线程 " + Thread.currentThread().getName() + " 被中断...");
        }
    }
}