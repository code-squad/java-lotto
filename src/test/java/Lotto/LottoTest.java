package Lotto;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    @Test
    public void 개수_반환() {
        LottoGame lottoGame = new LottoGame();
        lottoGame.setCount(14000);
        assertThat(lottoGame.getCount()).isEqualTo(14);
    }

    @Test
    public void 당첨개수() {
        List<String> winnerNumber = new ArrayList<>();
        winnerNumber.add("1");
        winnerNumber.add("3");
        winnerNumber.add("6");
        winnerNumber.add("10");
        winnerNumber.add("30");
        winnerNumber.add("31");
        winnerNumber.add("42");

        Integer[] lottoNumber = {1, 3, 5, 10, 12, 13, 14};
        LottoGame lottoGame = new LottoGame();
        assertThat(lottoGame.returnContainNumber(winnerNumber, lottoNumber)).isEqualTo(3);
    }

    @Test
    public void 총_수익률() {
        Lotto lotto = new Lotto();
        lotto.setMoney(10000);

        int[] array = new int[]{3, 3, 4, 4};

        for (int i : array) {
            lotto.setMatchCount(i);
        }

        assertThat(lotto.getYield()).isEqualTo(1100);
    }

}