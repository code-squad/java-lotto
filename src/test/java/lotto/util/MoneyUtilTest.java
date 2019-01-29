package lotto.util;

import lotto.domain.Lotto;
import lotto.domain.Rank;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.registerCustomDateFormat;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class MoneyUtilTest {

    private MoneyUtil moneyUtil = new MoneyUtil();
    private List<Lotto> getLottos() {
        List<Integer> a= new ArrayList<>();
        a.add(1);
        a.add(2);
        a.add(3);
        a.add(4);
        a.add(5);
        a.add(6);

        List<Integer> b = new ArrayList<>();
        b.add(1);
        b.add(2);
        b.add(3);
        b.add(4);
        b.add(8);
        b.add(9);

        List<Integer> c = new ArrayList<>();
        c.add(1);
        c.add(2);
        c.add(3);
        c.add(4);
        c.add(10);
        c.add(11);

        List<Integer> d = new ArrayList<>();
        d.add(1);
        d.add(27);
        d.add(28);
        d.add(4);
        d.add(10);
        d.add(11);

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
        a.add(24);
        a.add(15);
        return a;

    }

    @Test
    public void b() {
        List<Rank> a = LottoUtil.ranks();

        System.out.println(MoneyUtil.grade(a, getLottos(), xx()));

        assertThat(MoneyUtil.grade(a, getLottos(), xx()).get(1)).isEqualTo(3);
    }


    @Test
    public void a() {
        List<Rank> a = LottoUtil.ranks();

        assertThat(MoneyUtil.maxMoney(a, MoneyUtil.grade(a, getLottos(), xx()))).isEqualTo(150000);

    }

    @Test
    public void profitRate() {
        List<Rank> a = LottoUtil.ranks();
        List<Integer> x = MoneyUtil.grade(a, getLottos(), xx());

        int b = 3000;

        assertThat(MoneyUtil.profitRate(a, x, b)).isEqualTo(50);

    }



}