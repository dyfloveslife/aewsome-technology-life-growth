package other;

public class CodeBlockTest1 {

    CodeBlockTest1() {
        System.out.println("CodeBlockTest1 的构造器.");
    }

    {
        System.out.println("CodeBlockTest1 的非静态代码块 1");
    }

    {
        System.out.println("CodeBlockTest1 的非静态代码块 2");
    }

    static {
        System.out.println("CodeBlockTest1 的静态代码块 1");
    }

    static {
        System.out.println("CodeBlockTest1 的静态代码块 2");
    }
}

class Demo {
    public static void main(String[] args) {
        CodeBlockTest1 test1 = new CodeBlockTest1();

        System.out.println("====================");

        CodeBlockTest1 test2 = new CodeBlockTest1();
    }
}