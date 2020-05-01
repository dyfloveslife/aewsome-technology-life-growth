package Part_14;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

public class AtomicIntegerFieldUpdaterTest {
    private static AtomicIntegerFieldUpdater<User> atomicIntegerFieldUpdater = AtomicIntegerFieldUpdater.newUpdater(User.class, "age");

    public static void main(String[] args) {
        User user = new User("zhangsan", 25);
        System.out.println(atomicIntegerFieldUpdater.getAndIncrement(user));
        System.out.println(atomicIntegerFieldUpdater.get(user));
    }


    static class User {
        private String name;
        // 注意这里需要使用 public volatile 修饰 age
        public volatile int age;

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
