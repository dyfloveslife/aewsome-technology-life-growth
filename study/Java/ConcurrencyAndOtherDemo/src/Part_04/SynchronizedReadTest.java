package Part_04;

public class SynchronizedReadTest {

    public static void main(String[] args) {
        final SynchronizedReadTest test = new SynchronizedReadTest();

        new Thread("A") {
            @Override
            public void run() {
                test.get(Thread.currentThread());
            }
        }.start();

        new Thread("B") {
            @Override
            public void run() {
                test.get(Thread.currentThread());
            }
        }.start();
    }

    public synchronized void get(Thread thread) {
        long start = System.currentTimeMillis();
        System.out.println("线程 " + thread.getName() + " 开始读操作...");
        while (System.currentTimeMillis() - start <= 1) {
            System.out.println("线程 " + thread.getName() + " 正在进行读操作...");
        }
        System.out.println("线程 " + thread.getName() + " 读操作完成...");
    }
}
