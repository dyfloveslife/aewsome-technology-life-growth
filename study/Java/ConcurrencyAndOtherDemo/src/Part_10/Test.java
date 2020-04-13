package Part_10;

public class Test {
    private static int a = 10;
    private static ThreadLocal<Integer> local;

    public static void main(String[] args) {

        Thread a = new Thread(new ThreadA());
        a.start();

        ThreadB b = new ThreadB();
        b.start();
    }

    static class ThreadA implements Runnable {

        @Override
        public void run() {
            local = new ThreadLocal<>();
            System.out.println("set 方法执行前: " + local.get() + " " + Thread.currentThread().getName());
            local.set(a + 10);
            System.out.println("set 方法执行后: " + local.get() + " " + Thread.currentThread().getName());
            System.out.println("remove 方法执行前: " + local.get() + " " + Thread.currentThread().getName());
            local.remove();
            System.out.println("remove 方法执行后: " + local.get() + " " + Thread.currentThread().getName());
        }
    }

    static class ThreadB extends Thread {

        @Override
        public void run() {
            System.out.println("另一个线程中的值: " + local.get() + " " + Thread.currentThread().getName());
        }
    }
}
