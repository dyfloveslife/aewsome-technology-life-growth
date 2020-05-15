//package Part_15;
//
//public class _02_2_LiskovSubstitutionPrinciple {
//    public static void main(String[] args) {
//        A a = new A();
//        System.out.println("3 - 1 = " + a.func1(3, 1));
//        System.out.println("8 - 2 = " + a.func1(8, 2));
//
//        System.out.println("==============");
//
//        B b = new B();
//        // 由于类 B 不再继承类 A，因此调用者就会很明确该函数完成的功能
//        System.out.println("3 + 1 = " + b.func1(3, 1));
//        System.out.println("8 + 2 = " + b.func1(8, 2));
//        System.out.println("3 + 1 + 10 = " + b.func2(3, 1));
//
//        System.out.println("==============");
//        System.out.println("3 - 1 = " + b.func3(3, 1));
//    }
//}
//
//class Base {
//    // 把更加基础的方法和成员放到 Base 类中
//}
//
//class A extends Base {
//    public int func1(int num1, int num2) {
//        return num1 - num2;
//    }
//}
//
//class B extends Base {
//    private A a = new A();
//
//    public int func1(int value1, int value2) {
//        return value1 + value2;
//    }
//
//    public int func2(int value1, int value2) {
//        return func1(value1, value2) + 10;
//    }
//
//    // 调用类 A 中的求差方法
//    public int func3(int value1, int value2) {
//        return a.func1(value1, value2);
//    }
//}