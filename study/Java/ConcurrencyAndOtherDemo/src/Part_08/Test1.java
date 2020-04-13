package Part_08;

import java.util.ArrayList;
import java.util.List;

// 资源
class MyQueue {
    private List list = new ArrayList();

    // 负责生产
    public synchronized void push() {
        try {
            while (list.size() == 1) {
                System.out.println("队列已满，线程 " + Thread.currentThread().getName() + " 呈 wait 状态...");
                wait();
            }
            list.add(" " + Math.random());
            System.out.println("线程 " + Thread.currentThread().getName() + " 生产了，队列已满...");
            notifyAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // 负责消费
    public synchronized String pop() {
        String temp = "";
        try {
            while (list.size() == 0) {
                System.out.println("队列已空，线程 " + Thread.currentThread().getName() + " 呈 wait 状态...");
                wait();
            }
            temp = "" + list.get(0);
            list.remove(0);
            System.out.println("线程 " + Thread.currentThread().getName() + " 消费了，队列已空...");
            notifyAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return temp;
    }
}


// 生产者线程
class ProducerThread extends Thread {
    private MyQueue queue;

    public ProducerThread(MyQueue queue, String name) {
        super(name);
        this.queue = queue;
    }

    public void pushService() {
        queue.push();
    }

    @Override
    public void run() {
        queue.push();
    }
}


// 消费者线程
class ConsumerThread extends Thread {
    private MyQueue queue;

    public ConsumerThread(MyQueue queue, String name) {
        super(name);
        this.queue = queue;
    }

    @Override
    public void run() {
        queue.pop();
    }
}


public class Test1 {

    public static void main(String[] args) {
        MyQueue queue = new MyQueue();

        new ProducerThread(queue, "Producer1").start();
        new ProducerThread(queue, "Producer2").start();
        new ProducerThread(queue, "Producer3").start();
        new ProducerThread(queue, "Producer4").start();
        new ProducerThread(queue, "Producer5").start();

        new ConsumerThread(queue, "Consumer1").start();
        new ConsumerThread(queue, "Consumer2").start();
        new ConsumerThread(queue, "Consumer3").start();
        new ConsumerThread(queue, "Consumer4").start();
        new ConsumerThread(queue, "Consumer5").start();
        new ConsumerThread(queue, "Consumer6").start();
        new ConsumerThread(queue, "Consumer7").start();
    }
}
