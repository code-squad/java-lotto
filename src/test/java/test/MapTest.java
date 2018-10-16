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
}
