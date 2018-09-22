package lotto.domain;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.Rank;
import lotto.domain.WinLotto;
import org.junit.Test;

import java.util.Map;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class LottosTest {
    @Test
    public void 항목한개추가() {
        Lottos lottos = new Lottos();
        lottos.add( new Lotto("1, 2, 3, 4, 5, 6") );
        assertThat(lottos.getLottosCount()).isEqualTo(1);
    }

    @Test
    public void 랭킹맵초기화확인() {
        Lottos lottos = new Lottos();
        Lotto lotto = new Lotto("1, 2, 3, 4, 5, 6");
        lottos.add( lotto);
        WinLotto winLotto = new WinLotto(lotto, 15);
        Map<Rank,Integer> map = lottos.makeRankCountMap(winLotto);

        assertThat(map.size()).isEqualTo(6);
    }

    @Test
    public void 랭킴맵1등확인() {
        Lottos lottos = new Lottos();
        Lotto lotto = new Lotto("1, 2, 3, 4, 5, 6");
        lottos.add( lotto);
        WinLotto winLotto = new WinLotto(lotto, 15);
        Map<Rank,Integer> map = lottos.makeRankCountMap(winLotto);

        assertThat(map.get(Rank.FIRST)).isEqualTo(1);
    }

    @Test
    public void addLottos에_널체크여부테스트() {
        Lottos lottos = new Lottos();
        lottos.addLottos(null);
        assertThat(lottos.getLottosCount()).isEqualTo(0);
    }

    @Test
    public void add에_널체크여부테스트() {
        Lottos lottos = new Lottos();
        lottos.add(null);
        assertThat(lottos.getLottosCount()).isEqualTo(0);
    }
}
