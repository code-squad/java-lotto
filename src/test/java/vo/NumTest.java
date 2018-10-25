package vo;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
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
        TreeSet<Num> set = new TreeSet<>();
        set.add(new Num(1));

        List<Num> list = new ArrayList<>();
        list.add(new Num(1));

        assertThat(set.pollFirst()).isEqualTo(list.get(0)); // [== 로 비교X] [값을비교라 equal]

    }
}
