package other;

import java.io.*;

public class StaticSerializableTest implements Serializable {
    private static int age = 25;

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        // 序列化
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("staticSerializable.txt"));
        oos.writeObject(new StaticSerializableTest());
        oos.close();

        // 修改静态变量的值
        StaticSerializableTest.age = 30;

        // 反序列化
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("staticSerializable.txt"));
        StaticSerializableTest ss = null;
        ss = (StaticSerializableTest) ois.readObject();

        System.out.println(ss.age);
    }
}
