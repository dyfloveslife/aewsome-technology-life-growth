package Part_07;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockConditionDemo {
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public static void main(String[] args) throws InterruptedException {
        LockConditionDemo demo = new LockConditionDemo();

        new Thread(() -> demo.awaitMethod(), "thread-1").start();
        Thread.sleep(3000);
        new Thread(() -> demo.signalMethod(), "thread-2").start();
    }

    private void awaitMethod() {
        try {
            lock.lock();
            System.out.println("开始等待 await...ThreadName: " + Thread.currentThread().getName());
            condition.await();
            System.out.println("等待 await 结束...ThreadName: " + Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void signalMethod() {
        lock.lock();
        System.out.println("发送通知 signal...ThreadName: " + Thread.currentThread().getName());
        condition.signal();
        lock.unlock();
    }
}
