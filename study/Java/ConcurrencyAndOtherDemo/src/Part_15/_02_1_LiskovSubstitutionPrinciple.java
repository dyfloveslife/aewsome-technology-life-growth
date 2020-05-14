package Part_15;


public class _02_1_LiskovSubstitutionPrinciple {
    public static void main(String[] args) {
        A1 a = new A1();
        System.out.println("3 - 1 = " + a.func1(3, 1));
        System.out.println("8 - 2 = " + a.func1(8, 2));

        System.out.println("==============");

        B1 b = new B1();
        System.out.println("3 - 1 = " + b.func1(3, 1));
        System.out.println("8 - 2 = " + b.func1(8, 2));
        System.out.println("3 + 1 + 10 = " + b.func2(3, 1));
    }
}

class A1 {
    public int func1(int num1, int num2) {
        return num1 - num2;
    }
}

class B1 extends A1 {
    public int func1(int value1, int value2) {
        return value1 + value2;
    }

    public int func2(int value1, int value2) {
        return func1(value1, value2) + 10;
    }
}