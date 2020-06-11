package Part_22;

// 描述当前调料以及调料的价格
public class Chocolate extends Decorator {
    public Chocolate(Drink drink) {
        super(drink);
        setDes("Chocolate...");
        setPrice(2.0F);
    }
}
