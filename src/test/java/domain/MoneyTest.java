package domain;

import org.junit.Test;
import vo.Rank;

import java.util.HashMap;
import java.util.Map;

import static domain.Money.LOTTO_PRICE;
import static org.assertj.core.api.Assertions.assertThat;
import static vo.Rank.*;

public class MoneyTest {
    @Test
    public void 로또금액생성() {
        new Money(3000);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 로또금액생성_금액부족() {
        new Money(500);

    }

    @Test(expected = IllegalArgumentException.class)
    public void 로또금액생성_잘못된금액단위() {
        new Money(1500);
    }

    @Test
    public void 로또금액_수량확인() {
        //given
        Money money = new Money(5000);

        //when
        int lottoAmount = money.getLottoAmount();

        //then
        assertThat(lottoAmount).isEqualTo(5);
    }

    @Test
    public void 총수익률계산() {
        //given
        Map<Rank, Integer> rankCount = new HashMap<>();
        rankCount.put(FIRST, 0);
        rankCount.put(SECOND, 1);
        rankCount.put(THIRD, 0);
        rankCount.put(FOURTH, 1);
        rankCount.put(FIFTH, 0);
        rankCount.put(FAIL, 3);
        Money money = new Money(5000);
        int expectedResult = (SECOND.getWinningMoney() + FOURTH.getWinningMoney()) / (5 * LOTTO_PRICE);

        //when
        int totalRateOfReturn = money.calculateTotalRateOfReturn(rankCount);

        //then
        assertThat(totalRateOfReturn).isEqualTo(expectedResult);
    }
}