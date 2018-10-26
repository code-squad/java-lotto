package dto;

import org.junit.Test;
import vo.Num;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class LottoDtoTest {
    @Test
    public void print() {
        TreeSet<Num> set = new TreeSet<>();
        set.add(new Num(1));
        set.add(new Num(12));
        set.add(new Num(13));
        set.add(new Num(13));

        System.out.println(set);

    }
}