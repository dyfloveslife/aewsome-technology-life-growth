package Part_17;

// 普通房子
public class CommonHouse extends HouseBuilder {

    @Override
    public void buildBasic() {
        System.out.println("普通房子打桩 5 米...");
    }

    @Override
    public void buildWalls() {
        System.out.println("普通房子砌墙 2 米...");
    }

    @Override
    public void roofed() {
        System.out.println("普通房子封顶 1 米...");
    }
}
