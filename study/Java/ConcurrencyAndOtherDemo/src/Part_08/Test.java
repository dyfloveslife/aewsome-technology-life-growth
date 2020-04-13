package Part_08;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

// 资源类
class MyService {
    private ReentrantLock lock = new ReentrantLock();
    // 生产线程
    private Condition conditionA = lock.newCondition();
    // 消费线程
    private Condition conditionB = lock.newCondition();
    private boolean hasValue = false;

    public void set() {
        try {
            lock.lock();
            while (hasValue == true) {
                System.out.println("[生产线程] " + "线程: " + Thread.currentThread().getName() + " await...");
                conditionA.await();
            }
            System.out.println("[生产中] " + "线程: " + Thread.currentThread().getName() + " 生产~");
            Thread.sleep(1000);
            hasValue = true;
            System.out.println("线程: " + Thread.currentThread().getName() + " 生产完毕...");
            System.out.println("[唤醒所有消费线程] " + " 线程: " + Thread.currentThread().getName() + "...");
            conditionB.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void get() {
        try {
            lock.lock();
            while (hasValue == false) {
                System.out.println("[消费线程] " + "线程: " + Thread.currentThread().getName() + " await...");
                conditionB.await();
            }
            System.out.println("[消费中] " + " 线程: " + Thread.currentThread().getName() + " 消费~");
            Thread.sleep(1000);
            System.out.println("线程: " + Thread.currentThread().getName() + " 消费完毕...");
            hasValue = false;
            System.out.println("[唤醒所有生产线程] " + " 线程: " + Thread.currentThread().getName() + "...");
            conditionA.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

}

class MyThreadA extends Thread {
    private MyService myService;

    public MyThreadA(MyService myService, String name) {
        super(name);
        this.myService = myService;
    }

    @Override
    public void run() {
        while (true) {
            myService.set();
        }
    }
}


class MyThreadB extends Thread {
    private MyService myService;

    public MyThreadB(MyService myService, String name) {
        super(name);
        this.myService = myService;
    }

    @Override
    public void run() {
        while (true) {
            myService.get();
        }
    }
}

public class Test {
    public static void main(String[] args) {
        MyService myService = new MyService();

        MyThreadA[] threadA = new MyThreadA[10];
        MyThreadB[] threadB = new MyThreadB[10];

        for (int i = 0; i < 10; i++) {
            threadA[i] = new MyThreadA(myService, "ThreadA-" + i);
            threadB[i] = new MyThreadB(myService, "ThreadB-" + i);
            threadA[i].start();
            threadB[i].start();
        }
    }
}
