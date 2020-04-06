package Part_04;

public class SynchronizedTest2 {

    public static void main(String[] args) {

        final InsertData2 insertData = new InsertData2();

        new Thread(() -> insertData.insert1()).start();
        new Thread() {
            @Override
            public void run() {
                insertData.insert2();
            }
        }.start();
    }
}

class InsertData2 {
    public synchronized void insert1() {
        System.out.println("执行 insert1");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("执行 insert1 完毕");
    }

    public static synchronized void insert2() {
        System.out.println("执行 insert2");
        System.out.println("执行 insert2 完毕");
    }
}
