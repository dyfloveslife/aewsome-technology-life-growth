package Part_06;

import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicInteger;

public class MyBlockingQueue {

    // list 用于存放元素
    private final LinkedList<Object> list = new LinkedList<>();

    // 计数器
    private final AtomicInteger count = new AtomicInteger();

    private final int maxSize = 5;
    private final int minSize = 0;

    private final Object lock = new Object();

    public void put(Object obj) {
        synchronized (lock) {
            // 在添加元素的时候，如果已经达到了最大容量，则等待
            while (count.get() == maxSize) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            // 添加元素
            list.add(obj);
            // 计数器增加
            count.getAndIncrement();
            System.out.println("元素 " + obj + " 被添加到了 list 中...");
            // 通知另外一个阻塞的线程方法
            lock.notify();
        }
    }

    public Object get() {
        Object temp;
        synchronized (lock) {
            // 队列中没有元素了，则等待
            while (count.get() == minSize) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            count.getAndDecrement();
            temp = list.removeFirst();
            System.out.println("元素 " + temp + " 被消费了...");
            lock.notify();
        }
        return temp;
    }

    public int size() {
        return count.get();
    }

    public static void initMyBlockingQueue(MyBlockingQueue myBlockingQueue) {
        myBlockingQueue.put("1");
        myBlockingQueue.put("2");
        myBlockingQueue.put("3");
        myBlockingQueue.put("4");
        myBlockingQueue.put("5");
        System.out.println("阻塞队列中当前元素的个数：" + myBlockingQueue.size());
    }

    public static void main(String[] args) throws InterruptedException {

        final MyBlockingQueue myBlockingQueue = new MyBlockingQueue();
        initMyBlockingQueue(myBlockingQueue);

        Thread t1 = new Thread(() -> {
            myBlockingQueue.put("6");
            myBlockingQueue.put("7");
        }, "t1");

        Thread t2 = new Thread(() -> {
            try {
                Thread.sleep(2000);
                myBlockingQueue.get();
                Thread.sleep(2000);
                myBlockingQueue.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "t2");

        t1.start();
        Thread.sleep(1000);
        t2.start();
    }
}

