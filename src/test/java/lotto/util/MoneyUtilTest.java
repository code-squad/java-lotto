package lotto.util;

import lotto.domain.Lotto;
import lotto.domain.Rank;
import org.junit.Test;
import org.slf4j.Logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.registerCustomDateFormat;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.slf4j.LoggerFactory.getLogger;

public class MoneyUtilTest {

    private MoneyUtil moneyUtil = new MoneyUtil();
    private static final Logger log = getLogger(MoneyUtilTest.class);

    private List<Lotto> getLottos() {
        List<Integer> a = Arrays.asList(1, 2, 3, 4, 5, 11);
        List<Integer> b = Arrays.asList(1, 2, 3, 4, 5, 11);
        List<Integer> c = Arrays.asList(1, 2, 3, 4, 5, 11);
        List<Integer> d = Arrays.asList(1, 2, 3, 4, 5, 15);

        List<Lotto> lottos = Arrays.asList(new Lotto(a), new Lotto(b), new Lotto(c), new Lotto(d));
        return lottos;
    }

    public List<Integer> xx() {
        List<Integer> a = Arrays.asList(1, 2, 3, 4, 5, 15);
        return a;
    }

    @Test
    public void grade() {
        int bonus = 11;

        log.debug("{}", MoneyUtil.grade(getLottos(), xx(), bonus));
    }
}