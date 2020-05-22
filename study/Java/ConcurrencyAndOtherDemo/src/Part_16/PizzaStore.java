package Part_16;

/**
 * 相当于客户端，即用于发出订购披萨的订单
 */
public class PizzaStore {
    public static void main(String[] args) {
        new OrderPizza(new BJFactory());
    }
}
