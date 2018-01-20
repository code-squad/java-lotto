package lotto.domain;

import lotto.type.WinningType;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class OrderTest {
    private static final int TOTAL_COST = 14000;
    private Order order;

    @Test
    public void create() {
        order = new Order(TOTAL_COST);

        List<Lotto> lottos = order.getLottos();

        assertThat(lottos).isNotNull();
        assertThat(lottos.size()).isEqualTo(14);

    }

    @Test
    public void matchLotto() {
        order = new Order(TOTAL_COST);
        WinningLotto wLotto = new WinningLotto(Arrays.asList(1,2,3,4,5,6), 7);

        Lotto lotto = new Lotto(Arrays.asList(1,2,3,4,5,6));
        assertThat(order.matchLotto(wLotto, lotto)).isEqualTo(WinningType.MATCH_ALL);

        Lotto matchFiveWithBonus = new Lotto(Arrays.asList(1,2,3,4,5,7));
        assertThat(order.matchLotto(wLotto, matchFiveWithBonus)).isEqualTo(WinningType.MATCH_FIVE_WITH_BONUS);

        Lotto matchNone = new Lotto(Arrays.asList(10,11,12,13,14,15));
        assertThat(order.matchLotto(wLotto, matchNone)).isEqualTo(WinningType.NONE);


    }
}