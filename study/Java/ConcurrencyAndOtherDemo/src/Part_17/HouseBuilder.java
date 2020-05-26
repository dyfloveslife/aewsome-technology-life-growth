package Part_17;

// 抽象的建造者
public abstract class HouseBuilder {

    House house = new House();

    // 打桩
    public abstract void buildBasic();

    // 砌墙
    public abstract void buildWalls();

    // 封顶
    public abstract void roofed();

    // 建造完房子以后，将产品（房子）返回
    public House buildHouse() {
        return house;
    }
}
