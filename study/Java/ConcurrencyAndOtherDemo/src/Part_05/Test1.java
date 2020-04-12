package Part_05;

import java.util.ArrayList;
import java.util.List;

// 资源类
class MyList {

    // 临界资源
    private volatile List<String> list = new ArrayList<>();

    public void add() {
        list.add("123");
    }

    public int size() {
        return list.size();
    }
}


// 线程 A
class ThreadA extends Thread {
    private MyList list;

    public ThreadA(MyList list, String name) {
        super(name);
        this.list = list;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 5; i++) {
                list.add();
                System.out.println("添加了 " + (i + 1) + " 个元素.");
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

// 线程 B
class ThreadB extends Thread {
    private MyList list;

    public ThreadB(MyList list, String name) {
        super(name);
        this.list = list;
    }

    @Override
    public void run() {
        try {
            while (true) {
                if (list.size() == 4) {
                    System.out.println("list 的大小为 4 了，线程 B 要退出了!");
                    throw new InterruptedException();
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class Test1{
    public static void main(String[] args) {
        MyList service = new MyList();

        ThreadA a = new ThreadA(service, "A");
        ThreadB b = new ThreadB(service, "B");

        a.start();
        b.start();
    }
}