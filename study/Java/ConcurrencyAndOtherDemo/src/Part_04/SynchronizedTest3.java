package Part_04;

public class SynchronizedTest3 implements Runnable {

    public synchronized void get() {
        System.out.println(Thread.currentThread().getName());
        // 注意这里调用了被 synchronized 修饰的 set 方法
        set();
    }

    public synchronized void set() {
        System.out.println(Thread.currentThread().getName());
    }

    @Override
    public void run() {
        System.out.println("run start...");
        get();
        System.out.println("run end...");
    }

    public static void main(String[] args) {
        SynchronizedTest3 test = new SynchronizedTest3();
        new Thread(test, "Thread-0").start();
        new Thread(test, "Thread-1").start();
        new Thread(test, "Thread-2").start();
    }
}
