package other;

/**
 * 总结：成员变量初始化工作是在构造函数之后才会被调用
 */
public class Main {
    public static void main(String[] args) {
        Sub sub = new Sub();
        System.out.println(sub.str);
    }
}


class Base {
    // 3. 调用 Base 构造函数
    Base() {
        // 4. 调用 preProcess() 方法
        preProcess();
        System.out.println("Base Base().");
    }

    void preProcess() {
        System.out.println("Base preProcess().");
    }
}

// 1. 进入 Sub 的构造函数
class Sub extends Base {
    // 2. 为成员变量 str 分配内存
    // 6. 此时成员变量 str 才被初始化
    public String str = "set when declared.";

    // 7. 执行 Sub 的构造函数

    // 5. 由于子类重写了 preProcess() 方法，因此调用的是子类的
    void preProcess() {
        str = "set in sub preProcess().";
    }
}