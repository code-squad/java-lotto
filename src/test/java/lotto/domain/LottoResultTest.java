package lotto.domain;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Moonchan on 2018. 1. 16..
 */
public class LottoResultTest {

    public static final int TICKET_COUNT = 10;
    private LottoResult result;

    @Before
    public void setup() {
        List<Prize> prizeList = new ArrayList<>();
        prizeList.add(Prize.FIRST);
        prizeList.add(Prize.SECOND);
        prizeList.add(Prize.THIRD);
        prizeList.add(Prize.THIRD);
        result = new LottoResult(TICKET_COUNT, prizeList);
    }

    @Test
    public void 당첨결과() {
        assertThat(result.getPrizeCount(Prize.FIRST)).isEqualTo(1);
        assertThat(result.getPrizeCount(Prize.SECOND)).isEqualTo(1);
        assertThat(result.getPrizeCount(Prize.THIRD)).isEqualTo(2);
        assertThat(result.getPrizeCount(Prize.FOURTH)).isEqualTo(0);
        assertThat(result.getPrizeCount(Prize.NONE)).isEqualTo(0);
    }

    @Test
    public void 총상금() {
        long reward = Prize.FIRST.getReward() + Prize.SECOND.getReward() + (Prize.THIRD.getReward() * 2);
        assertThat(result.getTotalReward()).isEqualTo(reward);
    }

    @Test
    public void 수익률() {
        long reward = Prize.FIRST.getReward() + Prize.SECOND.getReward() + (Prize.THIRD.getReward() * 2);
        int money = TICKET_COUNT * LottoTicket.TICKET_PRICE;
        assertThat(result.getReturnRate()).isEqualTo((float)reward / money * 100);
    }

}