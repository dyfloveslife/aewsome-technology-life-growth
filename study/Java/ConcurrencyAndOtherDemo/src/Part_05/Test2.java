package Part_05;

public class Test2 {
    public static Object object = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread1 thread1 = new Thread1();
        Thread2 thread2 = new Thread2();

        thread1.start();
        Thread.sleep(2000);
        thread2.start();
    }

    static class Thread1 extends Thread {
        @Override
        public void run() {
            synchronized (object) {
                System.out.println("线程 " + Thread.currentThread().getName() + " 获取到了锁...");
                try {
                    System.out.println("线程 " + Thread.currentThread().getName() + " 阻塞并释放锁...");
                    object.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("线程 " + Thread.currentThread().getName() + " 执行完毕...");
            }
        }
    }

    static class Thread2 extends Thread {
        @Override
        public void run() {
            synchronized (object) {
                System.out.println("线程 " + Thread.currentThread().getName() + " 获取到了锁...");
                object.notify();
                System.out.println("线程 " + Thread.currentThread().getName() + " 唤醒了正在 wait 的线程...");
            }
            System.out.println("线程 " + Thread.currentThread().getName() + " 执行完毕...");
        }
    }
}
