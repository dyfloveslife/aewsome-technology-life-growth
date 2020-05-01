package Part_14;

import java.util.concurrent.atomic.AtomicIntegerArray;

public class AtomicIntegerArrayTest {

    public static void main(String[] args) {

        AtomicIntegerArray ai = new AtomicIntegerArray(new int[]{1, 2, 3});

        System.out.println(ai.get(0));
        System.out.println(ai.addAndGet(0, 5));
        System.out.println("--");

        System.out.println(ai.getAndAdd(1, 5));
        System.out.println(ai.get(1));
        System.out.println("--");

        System.out.println(ai.compareAndSet(2, 10, 30));
        System.out.println(ai.get(2));
        System.out.println("--");

        System.out.println(ai.compareAndSet(2, 3, 30));
        System.out.println(ai.get(2));
    }
}
