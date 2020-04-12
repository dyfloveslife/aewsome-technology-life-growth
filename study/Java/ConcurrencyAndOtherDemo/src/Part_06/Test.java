package Part_06;

import java.util.ArrayList;
import java.util.List;

class MyList {
    private static List<Integer> list = new ArrayList<>();

    public static void add() {
        list.add(123);
    }

    public static int size() {
        return list.size();
    }
}

class ThreadA extends Thread {
    private Object object;

    public ThreadA(Object object, String name) {
        super(name);
        this.object = object;
    }

    @Override
    public void run() {
        try {
            synchronized (object) {
                if (MyList.size() != 5) {
                    System.out.println("开始：" + System.currentTimeMillis());
                    object.wait();
                    System.out.println("结束：" + System.currentTimeMillis());
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class ThreadB extends Thread {
    private Object object;

    public ThreadB(Object object, String name) {
        super(name);
        this.object = object;
    }

    @Override
    public void run() {
        try {
            synchronized (object) {
                for (int i = 0; i < 10; i++) {
                    MyList.add();
                    System.out.println("添加了 " + (i + 1) + " 个元素...");
                    if (MyList.size() == 5) {
                        object.notify();
                        System.out.println("已调用 notify() 方法...");
                    }
                    Thread.sleep(1000);
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class Test {
    public static void main(String[] args) {
        try {
            Object object = new Object();

            ThreadA a = new ThreadA(object, "A");
            a.start();
            Thread.sleep(50);

            ThreadB b = new ThreadB(object, "B");
            b.start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
