package Part_01;

import java.util.concurrent.atomic.AtomicInteger;

public class CASTest {
    private AtomicInteger atomicInteger = new AtomicInteger(0);

    private void safeCount() {
        for (; ; ) {
            int i = atomicInteger.get();
            boolean suc = atomicInteger.compareAndSet(i, ++i);
            if (suc) {
                break;
            }
        }
    }

    private void unsafeCount() {
//        i++;
    }
}
