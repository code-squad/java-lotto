package lotto.domain;

import lotto.util.LottoUtil;
import org.junit.Test;
import org.slf4j.Logger;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.slf4j.LoggerFactory.getLogger;

public class LottoTest {

    private static final Logger log = getLogger(LottoTest.class);

    @Test
    public void matchNum() {
        List<Integer> a = new ArrayList<>();
        List<Integer> b = new ArrayList<>();

        for (int i = 1; i <= 6; i++) {
            a.add(i);
        }
        log.debug("로또값:{}", a);

        b.add(1);
        b.add(2);
        b.add(5);
        b.add(3);
        b.add(8);
        b.add(11);

        log.debug("b:{}", b);

        Lotto lotto = new Lotto(a);
        assertThat(lotto.matchNum(b)).isEqualTo(4);
    }

    @Test
    public void matchNumXX() {
        List<Integer> a = new ArrayList<>();
        List<Integer> b = new ArrayList<>();

        for (int i = 1; i <= 6; i++) {
            a.add(i);
        }
        log.debug("로또값:{}", a);

        b.add(1);
        b.add(2);
        b.add(7);
        b.add(8);
        b.add(9);
        b.add(11);

        log.debug("b:{}", b);

        Lotto lotto = new Lotto(a);
        assertThat(lotto.matchNum(b)).isEqualTo(0);
    }
}