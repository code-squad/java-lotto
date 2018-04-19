package Lotto;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    @Test(expected = IllegalArgumentException.class)
    public void 천원미만_입력() {
        assertThat(InputLottoView.checkInputMoney(1));
    }

    @Test
    public void 개수_반환() {
        LottoGame lottoGame = new LottoGame(14000);
        assertThat(lottoGame.getCount()).isEqualTo(14);
    }

    @Test
    public void 당첨개수() {
        List<String> winnerNumber = Arrays.asList("1", "3", "6", "10", "30", "31", "42");
        List<Integer> lottoNumber = Arrays.asList(1, 3, 6, 7, 8, 9, 11);
        LottoGame lottoGame = new LottoGame(14000);
        assertThat(lottoGame.returnContainNumber(winnerNumber, lottoNumber)).isEqualTo(3);
    }

    @Test
    public void 숫자_일치_개수() {
        List<Integer> winningCounts = Arrays.asList(6, 6, 6, 6);

        for (int i : winningCounts) {
            LottoGameResult.setMatchCount(i);
        }

        assertThat(LottoGameResult.getSixMatchCount()).isEqualTo(4);
    }

    @Test
    public void 총_수익률() {
        List<Integer> winningCounts = Arrays.asList(3, 3, 4, 4);

        for (int i : winningCounts) {
            LottoGameResult.setMatchCount(i);
        }

        assertThat(LottoGameResult.getYield(11000)).isEqualTo(1000);
    }

}