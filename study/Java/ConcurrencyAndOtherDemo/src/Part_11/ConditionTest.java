package Part_11;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionTest {

    public static void main(String[] args) {

        char[] ch1 = "123456".toCharArray();
        char[] ch2 = "ABCDEF".toCharArray();

        Lock lock = new ReentrantLock();
        // Condition 就是队列
        Condition condition1 = lock.newCondition();
        Condition condition2 = lock.newCondition();

        new Thread(() -> {
            try {
                lock.lock();
                for (char c1 : ch1) {
                    System.out.print(c1);
                    condition2.signal();
                    condition1.await();
                }
                // 注意
                condition2.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }, "t1").start();

        new Thread(() -> {
            try {
                lock.lock();
                for (char c2 : ch2) {
                    System.out.print(c2);
                    condition1.signal();
                    condition2.await();
                }
                // 注意
                condition1.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }, "t2").start();
    }
}
