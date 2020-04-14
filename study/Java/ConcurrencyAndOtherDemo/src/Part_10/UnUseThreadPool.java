package Part_10;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class UnUseThreadPool {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        final List<Integer> list = new ArrayList<>();
        final Random random = new Random();
        for (int i = 0; i < 20000; i++) {
            // 可以使用 JDK1.8 新特性中的 lambda 表达式来创建线程
            // Thread thread = new Thread(() -> list.add(random.nextInt()));

            Thread thread = new Thread() {
                @Override
                public void run() {
                    list.add(random.nextInt());
                }
            };
            thread.start();
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("用时: " + (System.currentTimeMillis() - startTime));
        System.out.println("list 中元素的数量: " + list.size());
    }
}
