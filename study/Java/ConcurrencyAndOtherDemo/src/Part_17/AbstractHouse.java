package Part_17;

public abstract class AbstractHouse {
    // 打桩
    public abstract void buildBasic();

    // 砌墙
    public abstract void buildWalls();

    // 封顶
    public abstract void roofed();

    // 盖房子
    public void build() {
        buildBasic();
        buildWalls();
        roofed();
    }
}
