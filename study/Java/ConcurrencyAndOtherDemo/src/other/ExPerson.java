package other;

import java.io.*;

public class ExPerson implements Externalizable {
    private String name;
    private int age;

    public ExPerson() {
        System.out.println("无参构造.");
    }

    public ExPerson(String name, int age) {
        this.name = name;
        this.age = age;
        System.out.println("有参构造.");
    }

    @Override
    public String toString() {
        return name + age;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        System.out.println("writeExternal() method.");
        out.writeObject(name);
        out.writeInt(age);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        System.out.println("readExternal() method.");
        name = (String) in.readObject();
        age = in.readInt();
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ExPerson exPerson = new ExPerson("zhangsan", 25);
        System.out.println(exPerson);
        // 序列化
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("123.txt"));
        System.out.println("保存对象：");
        oos.writeObject(exPerson);
        oos.close();

        // 反序列化
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("123.txt"));
        System.out.println("接收对象：");
        exPerson = (ExPerson) ois.readObject();
        System.out.println(exPerson);
    }
}
