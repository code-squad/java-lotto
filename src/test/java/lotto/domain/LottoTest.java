package lotto.domain;

import org.junit.Test;
import org.slf4j.Logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.extractProperty;
import static org.assertj.core.api.AssertionsForClassTypes.fail;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.slf4j.LoggerFactory.getLogger;

public class LottoTest {

    private static final Logger log = getLogger(LottoTest.class);
    private static final int BONUS = 11;

    @Test
    public void matchNum() {
        List<Integer> b = Arrays.asList(1, 2, 5, 8, 3, 11);
        getLog(b);
        assertThat(getLotto().matchNum(b)).isEqualTo(4);
    }

    @Test
    public void matchList() {
        List<Integer> b = Arrays.asList(1, 2, 3, 4, 5, 11);
        getLog(b);
        log.debug("확인용 : {}", getLotto().matchList(b));
    }

    @Test
    public void bonusNumber() {
        List<Integer> b = Arrays.asList(1, 2, 3, 4, 5, 11);
        getLog(b);
        assertThat(getLotto().bonusCheck(getA(), BONUS)).isEqualTo(false);
    }

    @Test
    public void matchNumXX() {
        List<Integer> b = Arrays.asList(1, 2, 7, 8, 9, 11);
        getLog(b);
        assertThat(getLotto().bonusCheck(getA(), BONUS)).isEqualTo(false);
    }

    @Test
    public void matchNumX2() {
        List<Integer> b = Arrays.asList(1, 2, 3, 4, 5, 13);
        getLog(b);
        assertThat(getLotto().bonusCheck(getA(), BONUS)).isEqualTo(false);
    }

    private List<Integer> getA() {
        return Arrays.asList(1, 2, 3, 4, 5, 6);
    }

    private Lotto getLotto() {
        return new Lotto(getA());
    }

    private void getLog(List<Integer> b) {
        log.debug("로또값:{}", getA());
        log.debug("추첨:{}", b);
    }
}