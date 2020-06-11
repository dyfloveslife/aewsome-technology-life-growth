package Part_22;

public class Coffee extends Drink {
    @Override
    public float cost() {
        return super.getPrice();
    }
}
