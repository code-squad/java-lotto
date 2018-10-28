package dto;

import org.junit.Test;
import vo.Num;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

public class LottoDtoTest {
    @Test
    public void print() {
        Num[] num = {new Num(1),new Num(12),new Num(13),new Num(13)};
        TreeSet<Num> set = new TreeSet<>(Arrays.asList(num));
        System.out.println(set);

    }
}