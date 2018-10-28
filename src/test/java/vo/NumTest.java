package vo;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import static org.assertj.core.api.Assertions.assertThat;

public class NumTest {


    @Test
    public void NumberTest() {
        Num number1 = new Num(3);
        Num number2 = new Num(3);
        assertThat(number1).isEqualTo(number2);
    }

    @Test
    public void valueCompareTest() {
        Set<Num> set = new TreeSet<>();
        set.add(new Num(1));

        Set<Num> list = new TreeSet<>();
        list.add(new Num(1));

        System.out.println(set.contains(((TreeSet<Num>) list).pollFirst()));
    }
}
