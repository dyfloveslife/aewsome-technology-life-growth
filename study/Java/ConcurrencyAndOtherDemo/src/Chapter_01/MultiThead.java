package Chapter_01;

class MultiThreadDemo implements Runnable{

    public void run() {
        System.out.println("Thread " + Thread.currentThread().getId() + " is running.");
    }

}

public class MultiThead {
    public static void main(String[] args) {
        int n = 10;
        for (int i = 0; i < n; i++) {
            Thread t = new Thread(new MultiThreadDemo());
            t.start();
        }
    }
}