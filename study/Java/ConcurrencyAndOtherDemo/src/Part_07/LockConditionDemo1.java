package Part_07;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class ThreadA extends Thread {
    private MyService service;

    public ThreadA(MyService service, String name) {
        super(name);
        this.service = service;
    }

    @Override
    public void run() {
        service.awaitA();
    }
}


class ThreadB extends Thread {
    private MyService service;

    public ThreadB(MyService service, String name) {
        super(name);
        this.service = service;
    }

    @Override
    public void run() {
        service.awaitB();
    }
}

class MyService {
    private Lock lock = new ReentrantLock();
    // 使用多个 Condition 实现通知部分线程
    public Condition conditionA = lock.newCondition();
    public Condition conditionB = lock.newCondition();

    public void awaitA() {
        lock.lock();
        try {
            System.out.println("begin awaitA 时间为: " + System.currentTimeMillis()
                    + " ThreadName: " + Thread.currentThread().getName());
            conditionA.await();
            System.out.println("end awaitA 时间为: " + System.currentTimeMillis()
                    + " ThreadName: " + Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void awaitB() {
        lock.lock();
        try {
            System.out.println("begin awaitB 时间为: " + System.currentTimeMillis()
                    + " ThreadName: " + Thread.currentThread().getName());
            conditionB.await();
            System.out.println("end awaitB 时间为: " + System.currentTimeMillis()
                    + " ThreadName: " + Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }


    public void signalAll_A() {
        try {
            lock.lock();
            System.out.println("signalAll_A 时间为: " + System.currentTimeMillis()
                    + " ThreadName: " + Thread.currentThread().getName());
            conditionA.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public void signalAll_B() {
        try {
            lock.lock();
            System.out.println("signalAll_B 时间为: " + System.currentTimeMillis()
                    + " ThreadName: " + Thread.currentThread().getName());
            conditionB.signalAll();
        } finally {
            lock.unlock();
        }
    }
}


public class LockConditionDemo1 {
    public static void main(String[] args) throws InterruptedException {
        MyService service = new MyService();

        ThreadA a = new ThreadA(service, "A");
        a.start();

        ThreadA b = new ThreadA(service, "B");
        b.start();

        Thread.sleep(3000);
        service.signalAll_A();
    }
}
