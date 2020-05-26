package Part_17;

public class Client {
    public static void main(String[] args) {
        // 现在想要建造普通的房子
        CommonHouse commonHouse = new CommonHouse();
        // 准备建造房子的指挥者
        HouseDirector houseDirector = new HouseDirector(commonHouse);
        // 完成盖房子，返回产品（房子）
        houseDirector.constructHouse();

        System.out.println("=================");

        HighHouse highHouse = new HighHouse();
        houseDirector.setHouseBuilder(highHouse);
        houseDirector.constructHouse();
    }
}
