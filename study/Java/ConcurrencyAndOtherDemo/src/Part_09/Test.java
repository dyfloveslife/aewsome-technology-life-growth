package Part_09;

public class Test {

    public static void main(String[] args) {
        System.out.println("进入线程: " + Thread.currentThread().getName());
        Test test = new Test();
        MyThread thread = test.new MyThread();
        thread.start();

        try {
            System.out.println("线程: " + thread.currentThread().getName() + "等待...");
            thread.join();
            System.out.println("线程: " + thread.currentThread().getName() + " 继续执行...");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println("进入线程: " + Thread.currentThread().getName());
            try {
                Thread.currentThread().sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("线程: " + Thread.currentThread().getName() + " 执行完毕...");
        }
    }
}
