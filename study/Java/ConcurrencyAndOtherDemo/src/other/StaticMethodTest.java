package other;

public class StaticMethodTest {

    static int sum(int x, int y) {
        return x + y;
    }

    public static void main(String[] args) {
        int sum = StaticMethodTest.sum(1, 2);
        System.out.println(sum);
    }
}
