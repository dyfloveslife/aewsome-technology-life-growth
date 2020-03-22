package Chapter_02;

public class InterruptMethodInThreadNoBlockingTest {

    public static void main(String[] args) {
        InterruptThreadNoBlocking thread1 = new InterruptThreadNoBlocking();
        thread1.start();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
        }

        thread1.interrupt();
    }
}


class InterruptThreadNoBlocking extends Thread {
    @Override
    public void run() {
        int i = 0;
        while (i < Integer.MAX_VALUE) {
            System.out.println(i + "-while 在循环...");
            i++;
        }
    }
}