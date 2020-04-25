package Part_13;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierTest_02 {

    public static void main(String[] args) {
        CyclicBarrier cb = new CyclicBarrier(4, new Runnable() {
            @Override
            public void run() {
                System.out.println("123");
            }
        });


        for (int i = 0; i < 4; i++) {
            new Writer(cb).start();
        }
    }

    static class Writer extends Thread {
        private CyclicBarrier cb;

        public Writer(CyclicBarrier cb) {
            this.cb = cb;
        }

        @Override
        public void run() {
            System.out.println("线程 " + Thread.currentThread().getName() + " 正在写入数据...");
            try {
                Thread.sleep(5000); // 模拟写入数据动作
                System.out.println("线程 " + Thread.currentThread().getName() + " 写入数据完毕，等待其它线程写入完毕...");
                cb.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
            System.out.println("所有线程写入完毕，继续处理其它任务...");
        }
    }
}

