package Chapter_03;

/**
 * 测试 volatile 的可见性
 */
public class TestVolatile {
    public static void main(String[] args) {
        ThreadDemo td = new ThreadDemo();
        new Thread(td, "ThreadDemo").start();

        while (true) {
            System.out.println("!!!");
//            synchronized (TestVolatile.class){}
//            TestVolatile.test2();

//            TestVolatile.test1();
            if (td.flag) {
                System.out.println("线程 " + Thread.currentThread().getName() + " 即将跳出 while 循环体");
                break;
            }
        }
    }

    public static void test1() {
    }

    public synchronized static void test2() {
    }
}

class ThreadDemo implements Runnable {

    public  boolean flag = false;

    @Override
    public void run() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
        }
        flag = true;
        System.out.println("线程 " + Thread.currentThread().getName() + " 执行完毕: " + "置 false = " + flag);
    }
}
