package Part_04;

import java.util.ArrayList;
import java.util.List;

public class SynchronizedTest {

    public static void main(String[] args) {
        final InsertData insertData = new InsertData();
        // 启动第一个线程
        new Thread(() -> insertData.insert(Thread.currentThread())).start();

        // 启动第二个线程
        new Thread() {
            @Override
            public void run() {
                insertData.insert(Thread.currentThread());
            }
        }.start();
    }
}


class InsertData {
    // 临界资源
    private List<Integer> list = new ArrayList<>();
    private Object object = new Object();

    public void insert(Thread thread) {
        synchronized (object) {
            for (int i = 0; i < 10; i++) {
                System.out.println(thread.getName() + "正在插入数据: " + i);
                list.add(i);
            }
        }
    }
}