package Part_11;

import java.util.concurrent.ArrayBlockingQueue;

public class Test {

    private int queueSize = 10;
    private ArrayBlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<>(queueSize);

    public static void main(String[] args) {
        Test test = new Test();

        Producer producer = test.new Producer();
        Consumer consumer = test.new Consumer();

        producer.start();
        consumer.start();
    }

    class Consumer extends Thread {
        @Override
        public void run() {
            consume();
        }

        private void consume() {
            while (true) {
                try {
                    blockingQueue.take();
                    System.out.println("从队列中取出元素，队列剩余: " + blockingQueue.size() + " 个元素...");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    class Producer extends Thread {
        @Override
        public void run() {
            produce();
        }

        private void produce() {
            while (true) {
                try {
                    blockingQueue.put(1);
                    System.out.println("向队列中添加元素，队列剩余: " + blockingQueue.size() + " 个元素...");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
