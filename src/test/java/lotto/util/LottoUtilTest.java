package lotto.util;

import lotto.domain.Lotto;

import lotto.domain.Rank;
import org.junit.Test;
import org.slf4j.Logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.slf4j.LoggerFactory.getLogger;

public class LottoUtilTest {
    private static final Logger log = getLogger(LottoUtilTest.class);
    private static final int BONUS = 11;
    private LottoUtil lottoUtil = new LottoUtil();
    private List<Rank> ranks = LottoUtil.ranks();

    @Test
    public void lottoNumber() {
        assertThat(lottoUtil.lottoNumber().size()).isEqualTo(45);
    }

    @Test
    public void lotto() {
        int a = 5;
        for (Lotto lotto : lottoUtil.lottoObject(a)) {
            log.debug("로또:{}", lotto);
        }
    }

    @Test
    public void grade() {
        List<Integer> a = MoneyUtil.grade(getLottos(), xx(), BONUS);
        log.debug("{}", a);
    }

    @Test
    public void ranks() {
        List<Lotto> lottoList = getLottos();
        List<Integer> p = xx();

        for (Rank rank : ranks) {
            log.debug("rank:{}", rank.getCountOfMatch());
            log.debug("money:{}", rank.getWinningMoney());
        }
    }

    private List<Lotto> getLottos() {
        List<Integer> a = Arrays.asList(1, 2, 3, 4, 5, 11);
        List<Integer> b = Arrays.asList(1, 2, 3, 11, 2, 13);
        List<Integer> c = Arrays.asList(1, 2, 3, 14, 15, 16);
        List<Integer> d = Arrays.asList(1, 2, 3, 17, 18, 19);

        List<Lotto> lottos = Arrays.asList(new Lotto(a), new Lotto(b), new Lotto(c), new Lotto(d));

        return lottos;
    }

    public List<Integer> xx() {
        List<Integer> a = Arrays.asList(1, 2, 3, 4, 5, 45);
        return a;
    }
}