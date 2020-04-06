package Part_03;

/**
 * 创建线程的两种方式
 * 程序的输出结果与代码的执行顺序或调用顺序无关
 */
public class TestThread {

    public static void main(String[] args) {
        new Thread() {
            @Override
            public void run() {
                System.out.println("Thread.");
            }
        }.start();

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Runnable.");
            }
        });
        thread.start();

        System.out.println("main.");
    }
}
