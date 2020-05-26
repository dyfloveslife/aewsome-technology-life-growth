package Part_17;

// 高楼
public class HighHouse extends HouseBuilder {

    @Override
    public void buildBasic() {
        System.out.println("高楼打桩 10 米...");
    }

    @Override
    public void buildWalls() {
        System.out.println("高楼砌墙 5 米...");
    }

    @Override
    public void roofed() {
        System.out.println("高楼封顶 10 米...");
    }
}
