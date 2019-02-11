package lotto.util;

import lotto.domain.Lotto;

import lotto.domain.Rank;
import org.junit.Test;
import org.slf4j.Logger;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.slf4j.LoggerFactory.getLogger;

public class LottoUtilTest {
    private static final Logger log = getLogger(LottoUtilTest.class);
    private LottoUtil lottoUtil = new LottoUtil();

    @Test
    public void lottoNumber() {
       assertThat(lottoUtil.lottoNumber().size()).isEqualTo(45);
    }



    @Test
    public void lotto() {
        int a = 5;
        for (Lotto lotto : lottoUtil.lottoObject(a)) {
            System.out.println(lotto);
        }
    }

    @Test
    public void grade(){
        List<Rank> ranks = LottoUtil.ranks();

        int bonus = 11;

        List<Integer> a = MoneyUtil.grade(getLottos(), xx(), bonus);

        System.out.println(a);


    }

    @Test
    public void ranks() {
        int bonus = 11;

        List<Lotto> lottoList = getLottos();
        List<Integer> p = xx();

        List<Rank> ranks = LottoUtil.ranks();

        for (Rank rank : ranks) {
            log.debug("rank:{}", rank.getCountOfMatch());
            log.debug("money:{}", rank.getWinningMoney());
        }
    }


    private List<Lotto> getLottos() {
        List<Integer> a= new ArrayList<>();
        a.add(1);
        a.add(2);
        a.add(3);
        a.add(4);
        a.add(5);
        a.add(11);

        List<Integer> b = new ArrayList<>();
        b.add(1);
        b.add(2);
        b.add(3);
        b.add(11);
        b.add(12);
        b.add(13);

        List<Integer> c = new ArrayList<>();
        c.add(1);
        c.add(2);
        c.add(3);
        c.add(14);
        c.add(15);
        c.add(16);

        List<Integer> d = new ArrayList<>();
        d.add(1);
        d.add(2);
        d.add(3);
        d.add(17);
        d.add(18);
        d.add(19);

        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(a));
        lottos.add(new Lotto(b));
        lottos.add(new Lotto(c));
        lottos.add(new Lotto(d));
        return lottos;
    }

    public List<Integer> xx(){
        List<Integer> a = new ArrayList<>();
        a.add(1);
        a.add(2);
        a.add(3);
        a.add(4);
        a.add(5);
        a.add(45);
        return a;

    }
}