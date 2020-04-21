package Part_12;

public class AQS01 {
    public static int m = 0;

    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[100];

        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < 100; j++) {
                    m++;
                }
            });
        }

        for (Thread t : threads) {
            t.start();
        }

        // 主线程需要等到所有的 threads 运行结束后才能打印 m
        for (Thread t : threads) {
            t.join();
        }
        System.out.println(m);
    }
}
