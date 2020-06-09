package Part_21;

public class Client {

    public static void main(String[] args) {
//        Phone phone = new Phone();
//        phone.charging(new VoltageAdapter(new Voltage220V()));

        AbsAdapter absAdapter = new AbsAdapter() {
            // 真正想要适配的是 fun1() 方法
            @Override
            public void fun1() {
                System.out.println("使用了 fun1 方法");
            }
        };
        absAdapter.fun1();
    }
}
