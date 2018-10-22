package test;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class MapTest {
    @Test
    public void test(){
        Map<Integer, Integer> map = new HashMap<>();
        System.out.println(map.get(1));
    }
    @Test
    public void mapTest(){
        Map<String, Integer> map = new HashMap<>();
        map.put("1", 1);
        map.put("1", 5);
        System.out.println(map);
    }

}
