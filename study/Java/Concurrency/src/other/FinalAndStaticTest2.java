package other;

public class FinalAndStaticTest2 {
    public static final int A = 123; // 该变量只能读，不能修改
    public final int B; // 必须在初始化的时候对该变量进行赋值

    FinalAndStaticTest2(int x) {
        B = x;
    }

    public static void main(String[] args) {
        FinalAndStaticTest2 f = new FinalAndStaticTest2(456);
        // f.A = 1;

        System.out.println(f.B); // 输出 456
    }
}
