package other;

import java.io.*;

public class SerializableDemo {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        // 序列化
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("456.txt"));
        oos.writeObject(Singleton.getInstance());
        oos.close();

        // 反序列化
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("456.txt"));
        Singleton newSingleton = (Singleton)ois.readObject();

        // 比较是否相等
        System.out.println(Singleton.getInstance() == newSingleton);
    }
}
