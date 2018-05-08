package Lotto;

import org.junit.Test;

import java.util.ArrayList;
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

    @Test(expected = IllegalArgumentException.class)
    public void 수동입력() {
        assertThat(InputLottoView.checkPurchaseManualLottoCount(3, 2000));
    }


    @Test
    public void 자동_개수_반환() {
        List<Lotto> lottoNumbers = new ArrayList<>();
        LottoGame lottoGame = new LottoGame(14000, lottoNumbers);
        assertThat(lottoGame.getAutoCount()).isEqualTo(14);
    }

    @Test
    public void 수동_개수_반환() {
        List<Lotto> manualLottoNumbers = new ArrayList<>();
        manualLottoNumbers.add(Lotto.makeLottoNumber());
        manualLottoNumbers.add(Lotto.makeLottoNumber());
        LottoGame lottoGame = new LottoGame(14000, manualLottoNumbers);
        assertThat(lottoGame.getManualCount()).isEqualTo(2);
    }

    @Test
    public void 수동_자동_개수_반환() {
        List<String> lottoNumber = new ArrayList<>();
        for (int i = 1; i <= 6; i++) {
            lottoNumber.add(String.valueOf(i));
        }

        List<Lotto> manualLottoNumber = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            manualLottoNumber.add(Lotto.makeManualLottoNumber(lottoNumber));
        }

        LottoGame lottoGame = new LottoGame(14000, manualLottoNumber);
        assertThat(lottoGame.getManualCount()).isEqualTo(3);
        assertThat(lottoGame.getAutoCount()).isEqualTo(11);
    }

    @Test
    public void 숫자_일치_개수() {
        List<String> winningNumber = new ArrayList<>();
        List<String> lottoNumber = new ArrayList<>();
        for (int i = 1; i <= 6; i++) {
            winningNumber.add(String.valueOf(i));
            lottoNumber.add(String.valueOf(i));
        }
        Lotto winningLotto = Lotto.makeManualLottoNumber(winningNumber);
        Lotto lotto = Lotto.makeManualLottoNumber(lottoNumber);

        assertThat(winningLotto.contains(lotto)).isEqualTo(6);
    }

    @Test
    public void 보너스포함() {
        List<String> lottoNumber = new ArrayList<>();
        for (int i = 1; i <= 6; i++) {
            lottoNumber.add(String.valueOf(i));
        }
        Lotto userLottoNumbers = Lotto.makeManualLottoNumber(lottoNumber);
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
        Lotto winningLotto = Lotto.makeManualLottoNumber(winningNumber);
        Lotto lotto = Lotto.makeManualLottoNumber(lottoNumber);
        LottoGameResult.setPrizeCount(Rank.valueOf(winningLotto.contains(lotto), false));

        assertThat(LottoGameResult.totalYieldMoney()).isEqualTo(Rank.FIRST.getWinningMoney());
    }

}