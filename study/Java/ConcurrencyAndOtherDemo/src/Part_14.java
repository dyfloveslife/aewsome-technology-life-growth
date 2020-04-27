import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class Part_14 {

    public static void main(String[] args) {
        CopyOnWriteArrayList<String> writeArrayList = new CopyOnWriteArrayList<>();

        writeArrayList.add("a");
        writeArrayList.add("b");

        Iterator<String> iterator = writeArrayList.iterator();

        writeArrayList.add("c");

        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
