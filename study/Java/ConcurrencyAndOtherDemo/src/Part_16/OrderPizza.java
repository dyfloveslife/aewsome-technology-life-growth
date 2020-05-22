package Part_16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class OrderPizza {

    AbsFactory factory;

    public OrderPizza (AbsFactory factory) {
        setFactory(factory);
    }

    private void setFactory(AbsFactory factory) {
        this.factory = factory;
        Pizza pizza = null;
        String orderType = "";

        do {
            orderType = getType();
            pizza = factory.createPizza(orderType);
            if (pizza != null) {
                pizza.prepare();
                pizza.back();
                pizza.cut();
                pizza.box();
            } else {
                System.out.println("订购失败...");
            }
        } while (true);
    }

    private String getType() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("请输入披萨类型：");
            String str = reader.readLine();
            return str;
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }
}
