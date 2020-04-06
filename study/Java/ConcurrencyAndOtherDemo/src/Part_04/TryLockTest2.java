package Part_04;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TryLockTest2 {
    private Lock lock = new ReentrantLock();

    public static void main(String[] args) {
        TryLockTest2 test = new TryLockTest2();
        MyThread thread1 = new MyThread(test, "A");
        MyThread thread2 = new MyThread(test, "B");
        thread1.start();
        thread2.start();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread2.interrupt();
    }

    public void method(Thread thread) throws InterruptedException {
        if (lock.tryLock(4, TimeUnit.SECONDS)) {
            try {
                System.out.println("时间: " + System.currentTimeMillis() + " ,线程 " + thread.getName() + " 得到了锁...");
                long nowTime = System.currentTimeMillis();
                while (System.currentTimeMillis() - nowTime < 5000) {
                    // 为了避免 Thread.sleep() 而需要捕获 InterruptedException 而带来的理解上的困惑，
                    // 此处用这种方法空转5秒
                }
            } catch (Exception e) {

            } finally {
                System.out.println("时间: " + System.currentTimeMillis() + " ,线程 " + thread.getName() + " 释放了锁...");
                lock.unlock();
            }
        } else {
            System.out.println("线程 " + thread.getName() + " 放弃了对锁的获取...");
        }
    }
}

class MyThread extends Thread {
    private TryLockTest2 test2 = null;

    public MyThread(TryLockTest2 test2, String name) {
        super(name);
        this.test2 = test2;
    }

    @Override
    public void run() {
        try {
            test2.method(Thread.currentThread());
        } catch (InterruptedException e) {
            System.out.println("时间: " + System.currentTimeMillis() + " ,线程 " + Thread.currentThread().getName() + " 被中断...");
        }
    }
}