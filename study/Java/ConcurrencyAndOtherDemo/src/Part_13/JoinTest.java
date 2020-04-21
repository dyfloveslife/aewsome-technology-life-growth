package Part_13;

public class JoinTest {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("主线程 main 开始执行...");
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("线程 t1 完成...");
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("线程 t2 完成...");
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("t1 和 t2 均执行完毕...");
        System.out.println("继续执行主线程 main...");
        System.out.println("主线程 main 执行完毕...");
    }
}
