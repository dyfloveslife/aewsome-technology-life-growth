package Part_04;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TryLockTest {
    private List<Integer> list = new ArrayList<>();
    private Lock lock = new ReentrantLock();

    public static void main(String[] args) {
        TryLockTest test = new TryLockTest();

        new Thread("A") {
            public void run() {
                test.insertData(Thread.currentThread());
            }
        }.start();

        new Thread("B") {
            public void run() {
                test.insertData(Thread.currentThread());
            }
        }.start();
    }

    public void insertData(Thread thread) {
        if (lock.tryLock()) {
            try {
                System.out.println("线程 " + thread.getName() + " 得到了锁...");
                for (int i = 0; i < 5; i++) {
                    list.add(i);
                }
            } catch (Exception e) {

            } finally {
                System.out.println("线程 " + thread.getName() + " 释放了锁...");
                lock.unlock();
            }
        } else {
            System.out.println("线程 " + thread.getName() + " 获取锁失败...");
        }
    }
}
