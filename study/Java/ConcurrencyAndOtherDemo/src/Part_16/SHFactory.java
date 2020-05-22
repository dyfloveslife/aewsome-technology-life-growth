package Part_16;

public class SHFactory implements AbsFactory {
    @Override
    public Pizza createPizza(String orderType) {
        Pizza pizza = null;
        if (orderType.equals("greek")) {
            pizza = new SHGreekPizza();
        } else if (orderType.equals("cheese")) {
            pizza = new SHCheesePizza();
        }
        return pizza;
    }
}
