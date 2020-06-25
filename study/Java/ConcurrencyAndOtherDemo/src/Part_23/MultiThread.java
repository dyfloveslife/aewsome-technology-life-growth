package Part_23;

public class MultiThread {
    private static char c = 'A';
    private static int i = 0;
    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            public void run() {
                synchronized(this) {
                    try {
                        int threadId = Integer.parseInt(Thread.currentThread().getName());
                        while (i < 26) {
                            if (i % 3 == threadId - 1) {
                                System.out.println("线程: " + threadId + "-" + c);
                                c++;
                                i++;
                                notifyAll();
                            } else {
                                wait();
                            }
                        }
                    } catch(InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        Thread t1 = new Thread(runnable, "1");
        Thread t2 = new Thread(runnable, "2");
        Thread t3 = new Thread(runnable, "3");
        t1.start();
        t2.start();
        t3.start();
    }
}