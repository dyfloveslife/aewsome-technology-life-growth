package other;

public class FinalAndStaticTest1 {
    public void m1() {
        System.out.println("父类中普通的 m1 方法");
    }

    public final void m2() {
        System.out.println("父类中被 final 修饰的 m2 方法");
    }

}

class FinalTest extends FinalAndStaticTest1 {
    public void m1() {
        System.out.println("子类中重写了父类中普通的 m1 方法");
    }

    public static void main(String[] args) {
        FinalTest ft = new FinalTest();
        ft.m1();
        ft.m2(); // 调用了从父类继承过来的 final m2 方法
    }
}
