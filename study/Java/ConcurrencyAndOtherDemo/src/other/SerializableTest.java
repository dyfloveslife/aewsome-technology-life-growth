package other;

import java.io.*;

public class SerializableTest {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
//        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("abc.txt"));
//        Person person = new Person("zhangsan", 24);
//        oos.writeObject(person);
//        oos.close();

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("abc.txt"));
        Person p = (Person) ois.readObject();
        System.out.println(p);
    }
}


