package Part_11;

/**
 * 使用对象调用 wait 方法，不是让对象去 wait，
 * 而是让当前持有该对象锁的线程进行 wait
 *
 * 但以下程序不能百分之百保证先输出 1，再输出 A，可以让其中一个线程先 wait，
 * 也可以在两个线程之间添加 sleep
 */
public class WaitNotifyTest {

    public static void main(String[] args) throws InterruptedException {
        final Object o = new Object();

        char[] c1 = "1234567".toCharArray();
        char[] c2 = "ABCDEFG".toCharArray();

        new Thread(() -> {
            synchronized (o) {
                for (char c : c1) {
                    System.out.print(c);
                    try {
                        o.notify();
                        // wait 方法会释放锁
                        o.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                // 因为最后肯定会有一个线程 wait 了，
                // 如果不加 o.notify() 的话则会一直阻塞
                o.notify();
            }
        }, "t1").start();

        Thread.sleep(1);

        new Thread(() -> {
            synchronized (o) {
                for (char c : c2) {
                    System.out.print(c);
                    try {
                        o.notify();
                        o.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                o.notify();
            }
        }, "t2").start();
    }
}
