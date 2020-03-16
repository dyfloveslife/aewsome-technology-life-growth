package Chapter_03;

/**
 * 测试 volatile 的原子性
 * volatile 无法保证操作的原子性
 */
class MyThread extends Thread {
    public static int count;

    // 添加 synchronized 关键字即可实现 count 的原子性
    public static void addCount() {
        for (int i = 0; i < 100; i++) {
            count++;
        }
        System.out.println("count= " + count);
    }

    public void run() {
        addCount();
    }
}

public class Run {
    public static void main(String[] args) {
        //  创建 100 个线程并启动
        MyThread[] myThreads = new MyThread[100];
        for (int i = 0; i < 100; i++) {
            myThreads[i] = new MyThread();
        }

        for (int i = 0; i < 100; i++) {
            myThreads[i].start();
        }
    }
}
