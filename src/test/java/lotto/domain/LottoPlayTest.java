package lotto.domain;

import org.junit.Test;
import org.slf4j.Logger;
import java.util.Arrays;
import java.util.List;

import static org.slf4j.LoggerFactory.getLogger;

public class LottoPlayTest {
    private static final Logger log = getLogger(LottoPlayTest.class);
    private static final int BONUS = 11;
    private LottoPlay lottoPlay = new LottoPlay();
    private List<Rank> ranks = LottoPlay.ranks(MoneyCheck.getWinnerMoneyList());
    
    @Test
    public void grade() {
        Grade grade = new Grade(getLottos(), getUser(), xx(), BONUS);
        List<Integer> a = MoneyCheck.grade(grade);
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

    private List<Lotto> getUser() {
        List<Integer> a = Arrays.asList(1, 2, 3, 4, 5, 11);
        List<Integer> b = Arrays.asList(1, 2, 3, 4, 5, 11);
        List<Integer> c = Arrays.asList(1, 2, 3, 4, 5, 11);
        List<Lotto> lottos = Arrays.asList(new Lotto(a), new Lotto(b), new Lotto(c));
        return lottos;
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