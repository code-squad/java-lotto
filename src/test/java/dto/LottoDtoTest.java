package dto;

import org.junit.Test;
import vo.Num;

import java.util.Arrays;
import java.util.TreeSet;

public class LottoDtoTest {
    @Test
    public void print() {
        TreeSet<Num> set = new TreeSet<>(Arrays.asList(new Num(1),new Num(12),new Num(13),new Num(13)));
        System.out.println(set);
    }
}