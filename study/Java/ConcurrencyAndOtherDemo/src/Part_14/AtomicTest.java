package Part_14;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicTest {

    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(1);

        System.out.println(atomicInteger.get());
        System.out.println(atomicInteger.getAndIncrement());
        System.out.println(atomicInteger.get());
        System.out.println(atomicInteger.incrementAndGet());
    }
}
