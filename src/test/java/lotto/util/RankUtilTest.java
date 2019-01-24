package lotto.util;

import lotto.domain.Lotto;
import lotto.domain.Rank;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class RankUtilTest {

    private RankUtil rankUtil = new RankUtil();

    @Test
    public void 사(){
        //5등 확인 완료
        List<Lotto> lottos = getLottos();

//        System.out.println(rankUtil.pageMoney(lottos, xx()));

//        int a = rankUtil.rackFourth(lottos, xx());


        System.out.println("확인" +rankUtil.rackFourth(lottos, xx()));

        System.out.println(rankUtil.rackFourth(lottos, xx()));


//        assertThat(rankUtil.rackFourth(lottos, xx())).isEqualTo(3);
    }

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

        List<Lotto> lottos = new ArrayList<>();
        lottos.add(new Lotto(a));
        lottos.add(new Lotto(b));
        lottos.add(new Lotto(c));
        return lottos;
    }

    public List<Integer> xx(){
        List<Integer> a = new ArrayList<>();
        a.add(1);
        a.add(2);
        a.add(3);
        a.add(4);
        a.add(14);
        a.add(15);
        return a;

    }

    @Test
    public void maxArray(){
        List<Lotto> lottos = getLottos();
        List<Integer> a = xx();

        List<Integer>b = rankUtil.pageMoney(lottos, a);
        System.out.println(rankUtil.pageMoney(lottos, a));
        System.out.println(rankUtil.pageMoney(lottos, b));
    }
}