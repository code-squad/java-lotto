package lotto;

import org.junit.Test;
import vo.Num;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {
    @Test
    public void FromListToSet() {
        List<Num> list = new ArrayList<>();
        list.add(new Num(1));
        list.add(new Num(3));
        list.add(new Num(6));
        list.add(new Num(3));

        Set<Num> set = new TreeSet<>(list);
        System.out.println(set);
    }

}
