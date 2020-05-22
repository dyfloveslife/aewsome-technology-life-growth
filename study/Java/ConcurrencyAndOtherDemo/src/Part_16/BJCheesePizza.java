package Part_16;

public class BJCheesePizza extends Pizza {
    @Override
    public void prepare() {
        setName("北京的 CheesePizza...");
        System.out.println("给 BJCheesePizza 准备原材料...");
    }
}
