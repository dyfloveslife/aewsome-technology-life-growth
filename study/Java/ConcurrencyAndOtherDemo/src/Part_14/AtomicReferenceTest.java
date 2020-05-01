package Part_14;

import java.util.concurrent.atomic.AtomicReference;

public class AtomicReferenceTest {

    static AtomicReference<User> ar = new AtomicReference<>();

    public static void main(String[] args) {

        User user = new User("zhangsan", 25);
        //ar.set(user);

        User updateUser = new User("lisi", 30);
        System.out.println(ar.compareAndSet(user, updateUser));

//        System.out.println(ar.get().getName());
//        System.out.println(ar.get().getAge());
    }

    static class User {
        private String name;
        private int age;

        public User(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }
    }
}
