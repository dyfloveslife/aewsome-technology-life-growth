package Part_04;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Test {

    private ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();

    public static void main(String[] args) {
        Test test = new Test();

        new Thread("A") {
            @Override
            public void run() {
                test.get(Thread.currentThread());
            }
        }.start();

        new Thread("B") {
            @Override
            public void run() {
                test.get(Thread.currentThread());
            }
        }.start();
    }

    public void get(Thread thread) {
        // 在外面定义
        rwl.readLock().lock();
        try {
            long start = System.currentTimeMillis();
            System.out.println("线程 " + thread.getName() + " 开始读操作...");
            while (System.currentTimeMillis() - start <= 1) {
                System.out.println("线程 " + thread.getName() + " 正在进行读操作...");
            }
            System.out.println("线程 " + thread.getName() + " 读操作完成...");
        } finally {
            rwl.readLock().unlock();
        }
    }
}
