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

    @Before
    public void setUp() throws Exception {
        order = new Order(TOTAL_COST);
    }

    @Test
    public void purchase() {
        List<Lotto> lottos = order.purchase();
        assertThat(lottos).isNotNull();
        assertThat(lottos.size()).isEqualTo(14);

    }

    @Test
    public void matchLotto() {
        WinningLotto wLotto = new WinningLotto(Arrays.asList(1,2,3,4,5,6), 7);

        Lotto lotto = new Lotto(Arrays.asList(1,2,3,4,5,6));
        assertThat(order.matchLotto(wLotto, lotto)).isEqualTo(WinningType.MATCH_ALL);

        Lotto matchFiveWithBonus = new Lotto(Arrays.asList(1,2,3,4,5,7));
        assertThat(order.matchLotto(wLotto, matchFiveWithBonus)).isEqualTo(WinningType.MATCH_FIVE_WITH_BONUS);

        Lotto matchNone = new Lotto(Arrays.asList(10,11,12,13,14,15));
        assertThat(order.matchLotto(wLotto, matchNone)).isEqualTo(WinningType.NONE);


    }
}