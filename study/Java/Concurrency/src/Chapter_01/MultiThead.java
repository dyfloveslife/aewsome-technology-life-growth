package Chapter_01;

class MultiThreadDemo extends Thread {

    public void run() {
        System.out.println("Thread " + Thread.currentThread().getId() + " is running.");
    }

}

public class MultiThead {
    public static void main(String[] args) {
        int n = 10;
        for (int i = 0; i < n; i++) {
//            MultiThreadDemo o = new MultiThreadDemo();
//            o.start();
            Thread t = new Thread(new MultiThreadDemo());
            t.start();
        }
    }
}