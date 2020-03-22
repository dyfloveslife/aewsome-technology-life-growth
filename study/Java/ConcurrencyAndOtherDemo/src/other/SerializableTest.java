package other;

import java.io.*;

public class SerializableTest {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Person person = new Person("zhangsan", 24, 180);
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("abc.txt"));
        oos.writeObject(person);
        oos.close();

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("abc.txt"));
        Person p = (Person) ois.readObject();
        System.out.println(p);
    }
}


