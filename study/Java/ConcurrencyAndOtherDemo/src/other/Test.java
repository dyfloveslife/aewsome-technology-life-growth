package other;

class A {

    A() {
        System.out.println("A 的构造器.");
    }

    {
        System.out.println("A 的非静态代码块 1.");
    }

    {
        System.out.println("A 的非静态代码块 2.");
    }

    static {
        System.out.println("A 的静态代码块 1.");
    }

    static {
        System.out.println("A 的静态代码块 2.");
    }
}

class B extends A {
    B() {
        System.out.println("B 的构造器.");
    }

    {
        System.out.println("B 的非静态代码块 1.");
    }

    {
        System.out.println("B 的非静态代码块 2.");
    }

    static {
        System.out.println("B 的静态代码块 1.");
    }

    static {
        System.out.println("B 的静态代码块 2.");
    }
}

class C extends B {
    C() {
        System.out.println("C 的构造器.");
    }

    {
        System.out.println("C 的非静态代码块 1.");
    }

    {
        System.out.println("C 的非静态代码块 2.");
    }

    static {
        System.out.println("C 的静态代码块 1.");
    }

    static {
        System.out.println("C 的静态代码块 2.");
    }
}

public class Test {
    public static void main(String[] args) {
        C c1 = new C();
        System.out.println("============");

        C c2 = new C();
    }
}