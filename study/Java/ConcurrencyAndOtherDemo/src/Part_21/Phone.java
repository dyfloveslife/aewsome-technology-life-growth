package Part_21;

public class Phone {

    public void charging(IVoltage5V iVoltage5V) {
        if (iVoltage5V.output5V() == 5) {
            System.out.println("电压为 5V，手机开始充电...");
        } else {
            System.out.println("电压不为 5V，不适合手机充电...");
        }
    }
}
