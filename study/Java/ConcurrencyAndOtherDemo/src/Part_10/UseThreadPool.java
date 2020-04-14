package Part_10;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 使用线程池
 */
public class UseThreadPool {

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        final List<Integer> list = new ArrayList<>();
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(
                100,
                100,
                60,
                TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(20000));

        final Random random = new Random();
        for (int i = 0; i < 20000; i++) {
            // 等价于 poolExecutor.execute(() -> list.add(random.nextInt()));
            poolExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    list.add(random.nextInt());
                }
            });
        }
        poolExecutor.shutdown();
        try {
            poolExecutor.awaitTermination(1, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("用时: " + (System.currentTimeMillis() - startTime));
        System.out.println("list 中元素的数量: " + list.size());
    }
}
