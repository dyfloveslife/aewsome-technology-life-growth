package Part_02;

public class InterruptMethodInThreadBlockingTest {

    public static void main(String[] args) {
        InterruptThreadBlocking thread = new InterruptThreadBlocking();
        thread.start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.interrupt();
    }
}

class InterruptThreadBlocking extends Thread {
    @Override
    public void run() {
        try {
            System.out.println("进入睡眠状态...");
            Thread.sleep(10000);
            System.out.println("睡眠完毕...");
        } catch (InterruptedException e) {
            System.out.println("发生中断异常...");
        }
        System.out.println("run 方法执行完毕...");
    }
}
