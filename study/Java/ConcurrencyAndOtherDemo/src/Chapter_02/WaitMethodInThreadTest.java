package Chapter_02;

/**
 * Thread 类中的 join 方法实例
 */
public class WaitMethodInThreadTest {
    public static void main(String[] args) {
        System.out.println("进入线程: " + Thread.currentThread().getName());

        ThreadDemo thread1 = new ThreadDemo();
        thread1.start();

        try {
            System.out.println("线程:" + Thread.currentThread().getName() + " 等待.");
            thread1.join();
            System.out.println("线程:" + Thread.currentThread().getName() + " 继续执行.");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


class ThreadDemo extends Thread {
    @Override
    public void run() {
        System.out.println("进入线程: " + Thread.currentThread().getName());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("线程: " + Thread.currentThread().getName() + " 执行完毕.");
    }
}