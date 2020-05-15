package Part_15;

public class _04_1_InterfaceSegregationPrinciple {
    public static void main(String[] args) {
        A a = new A();
        // 类 A 通过接口依赖类 B
        a.dependence1(new B());
        a.dependence2(new B());
        a.dependence3(new B());

        C c = new C();
        // 类 C 通过接口依赖类 D
        c.dependence1(new D());
        c.dependence4(new D());
        c.dependence5(new D());
    }
}

interface Interface1 {
    void method1();
}

interface Interface2 {
    void method2();

    void method3();
}

interface Interface3 {
    void method4();

    void method5();
}

class B implements Interface1, Interface2 {

    @Override
    public void method1() {
        System.out.println("类 B 中实现了 method1()...");
    }

    @Override
    public void method2() {
        System.out.println("类 B 中实现了 method2()...");
    }

    @Override
    public void method3() {
        System.out.println("类 B 中实现了 method3()...");
    }
}

class D implements Interface1, Interface3 {

    @Override
    public void method1() {
        System.out.println("类 D 中实现了 method1()...");
    }

    @Override
    public void method4() {
        System.out.println("类 D 中实现了 method4()...");
    }

    @Override
    public void method5() {
        System.out.println("类 D 中实现了 method5()...");
    }
}

// 类 A 通过接口 Interface1、Interface2 依赖了 B 类，使用到了 method1()、method2()、method3() 三个方法
class A {
    public void dependence1(Interface1 interface1) {
        interface1.method1();
    }

    public void dependence2(Interface2 interface2) {
        interface2.method2();
    }

    public void dependence3(Interface2 interface2) {
        interface2.method3();
    }
}

// 类 C 通过接口 Interface1、Interface3 依赖了 D 类，使用到了 method1()、method4()、method5()三个方法
class C {
    public void dependence1(Interface1 interface1) {
        interface1.method1();
    }

    public void dependence4(Interface3 interface3) {
        interface3.method4();
    }

    public void dependence5(Interface3 interface3) {
        interface3.method5();
    }
}