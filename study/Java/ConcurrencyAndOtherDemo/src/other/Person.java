package other;

import java.io.*;

public class Person implements Serializable {
    private transient String name;
    private transient int age;
    private int height;

    public Person() {
        System.out.println("无参构造.");
    }

    public Person(String name, int age, int height) {
        this.name = name;
        this.age = age;
        this.height = height;
        System.out.println("有参构造.");
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", height=" + height +
                '}';
    }
}
