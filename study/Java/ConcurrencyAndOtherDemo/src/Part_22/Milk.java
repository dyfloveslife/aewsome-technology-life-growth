package Part_22;

public class Milk extends Decorator {

    public Milk(Drink drink) {
        super(drink);
        setDes("Milk...");
        setPrice(1.2F);
    }
}
