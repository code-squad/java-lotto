package test;

import org.junit.Test;

import java.util.*;

public class CollectionTest {
    @Test
    public void test(){
        List<Integer> list = new ArrayList<>();
        list = Arrays.asList(1,2,3,4,5,6,7,8,9);

        List<Integer> list2 = new ArrayList<>(list.subList(0,3));
        System.out.println(list2);

        list.set(0, 9);
        list.set(1, 8);
        System.out.println(list2);
    }
}
