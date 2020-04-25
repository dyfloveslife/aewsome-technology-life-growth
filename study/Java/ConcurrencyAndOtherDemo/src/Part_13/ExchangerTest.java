package Part_13;

import java.util.concurrent.Exchanger;

public class ExchangerTest extends Thread {

    private String str;
    private Exchanger<String> exchanger;
    private int sleepSecond;

    public ExchangerTest(String str, Exchanger<String> exchanger, int sleepSecond) {
        this.str = str;
        this.exchanger = exchanger;
        this.sleepSecond = sleepSecond;
    }

    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName() + " 启动，原始数据为: " + str + "，时间为: " + sleepSecond);
            Thread.sleep(sleepSecond * 1000);
            // 交换数据
            str = exchanger.exchange(str);
            System.out.println(Thread.currentThread().getName() + " 交换了数据，交换后的数据为: " + str + "，时间为: " + sleepSecond);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Exchanger<String> exchanger = new Exchanger<>();
        ExchangerTest test1 = new ExchangerTest("111", exchanger, 3);
        ExchangerTest test2 = new ExchangerTest("222", exchanger, 2);

        test1.start();
        test2.start();
    }
}
