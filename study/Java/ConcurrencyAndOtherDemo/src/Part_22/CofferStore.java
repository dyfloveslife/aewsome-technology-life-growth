package Part_22;

// 咖啡店
public class CofferStore {
    public static void main(String[] args) {
        // 点一份 LongBlack
        Drink drink = new LongBlack();
        System.out.println("未装饰前：");
        System.out.println(drink.cost());
        System.out.println(drink.getDes());
        System.out.println("============================");

        // 加入牛奶，相当于对 LongBlack 进行了装饰
        drink = new Milk(drink);
        System.out.println("装饰后：");
        System.out.println(drink.cost());
        System.out.println(drink.getDes());
        System.out.println("============================");

        // 再加入一份巧克力
        drink = new Chocolate(drink);
        System.out.println("装饰后：");
        System.out.println(drink.cost());
        System.out.println(drink.getDes());
    }
}
