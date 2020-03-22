package other;

public class StaticBlockTest {

    public static int i;

    static {
        i = 1;
        System.out.println("静态代码块中的 i: " + i);
    }

    public static void main(String[] args) {
        StaticBlockTest test = new StaticBlockTest();
        System.out.println("main 方法中的 i: " + test.i);

        StaticBlockTest test1 = new StaticBlockTest();
    }
}
