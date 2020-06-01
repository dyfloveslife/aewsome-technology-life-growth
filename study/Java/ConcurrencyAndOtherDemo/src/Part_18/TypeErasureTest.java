package Part_18;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class TypeErasureTest {

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
//        List<String> list1 = new ArrayList<>();
//        list1.add("abc");
//
//        List<Integer> list2 = new ArrayList<>();
//        list2.add(123);
//
//        System.out.println(list1.getClass() == list2.getClass());

        List<Integer> list = new ArrayList<>();
        list.add(123);

        list.getClass().getMethod("add", Object.class).invoke(list, "abc");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        short s1 = 1;
        s1 += 1;


        short s2 = 1;
        s2 = (short) (s2 + 1);
    }
}
