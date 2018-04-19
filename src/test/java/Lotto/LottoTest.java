package Lotto;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    @Test(expected = IllegalArgumentException.class)
    public void 천원미만_입력() {
        assertThat(InputLottoView.checkInputMoney(1));
    }

    @Test(expected = IllegalArgumentException.class)
    public void 천원단위_입력() {
        assertThat(InputLottoView.checkInputMoney(1100));
    }

    @Test
    public void 개수_반환() {
        LottoGame lottoGame = new LottoGame(14000);
        assertThat(lottoGame.getCount()).isEqualTo(14);
    }

    @Test
    public void 숫자_일치_개수() {
        List<String> winningNumber = new ArrayList<>();
        List<String> lottoNumber = new ArrayList<>();
        for (int i = 1; i <= 6; i++) {
            winningNumber.add(String.valueOf(i));
            lottoNumber.add(String.valueOf(i));
        }
        Lotto winningLotto = Lotto.makeWinningNumber(winningNumber);
        Lotto lotto = Lotto.makeWinningNumber(lottoNumber);

        assertThat(winningLotto.contains(lotto)).isEqualTo(6);
    }

    @Test
    public void 보너스포함() {
        List<String> lottoNumber = new ArrayList<>();
        for (int i = 1; i <= 6; i++) {
            lottoNumber.add(String.valueOf(i));
        }
        Lotto userLottoNumbers = Lotto.makeWinningNumber(lottoNumber);
        assertThat(userLottoNumbers.makeBonusNumber(6)).isEqualTo(true);
    }

    @Test
    public void 총_수익률() {
        List<String> winningNumber = new ArrayList<>();
        List<String> lottoNumber = new ArrayList<>();
        for (int i = 1; i <= 6; i++) {
            winningNumber.add(String.valueOf(i));
            lottoNumber.add(String.valueOf(i));
        }
        Lotto winningLotto = Lotto.makeWinningNumber(winningNumber);
        Lotto lotto = Lotto.makeWinningNumber(lottoNumber);
        LottoGameResult.setPrizeCount(Rank.valueOf(winningLotto.contains(lotto), false));

        assertThat(LottoGameResult.totalYieldMoney()).isEqualTo(Rank.FIRST.getWinningMoney());
    }

}