package lotto;

import lotto.domain.Lotto;
import org.junit.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {
    @Test
    public void 랜덤섞기() {
        List<Integer> no = new ArrayList<>();
        no.add(1);
        no.add(1);
        no.add(2);
        no.add(6);
        no.add(1);

        Collections.shuffle(no);
        System.out.println(no);
    }

    @Test
    public void 중복제거() {
        Set<Integer> no = new HashSet<>();
        no.add(1);
        no.add(1);
        no.add(2);
        no.add(6);
        no.add(1);
        System.out.println(no);
    }

    @Test
    public void 로또비교() {
        Lotto lotto = Lotto.ofWinLotto("1,2,3,4,5,6");
        Lotto lotto2 = Lotto.ofWinLotto("1,2,3,4,5,6");
        System.out.println(lotto.obtainMatchCount(lotto2));
    }

    @Test
    public void win() {
        String[] values = "1,2,3,4,5,6".split(",");
        List<Integer> a = new ArrayList(Arrays.asList(values));
        a.add(7);
        System.out.println(a.get(0).getClass());
    }

    @Test
    public void map연습() {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(3,0);
        map.put(4,0);
        map.put(5,0);
        map.put(6,0);

        assertThat(map.get(3)).isEqualTo(0);
        map.put(3,1);
        assertThat(map.get(3)).isEqualTo(1);
    }
}
