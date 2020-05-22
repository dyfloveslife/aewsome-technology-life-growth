package Part_16;

public class BJFactory implements AbsFactory{
    @Override
    public Pizza createPizza(String orderType) {
        Pizza pizza = null;
        if (orderType.equals("greek")) {
            pizza = new BJGreekPizza();
        } else if (orderType.equals("cheese")) {
            pizza = new BJCheesePizza();
        }
        return pizza;
    }
}
