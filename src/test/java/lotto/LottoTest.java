package lotto;

import lotto.exception.ManualPurchaseLessThanZeroException;
import lotto.exception.NotEnoughMoneyException;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    private static final String manualLottoTicket = "1, 2, 3, 4, 5, 6";
    private static final String winningLottoTicket = "1, 2, 3, 4, 5, 6";

    @Test(expected = NotEnoughMoneyException.class)
    public void 수동_개수_금액초과() {
        Money money = new Money(2000);
        assertThat(InputLottoView.checkPurchaseManualLottoCount(3, money));
    }

    @Test(expected = ManualPurchaseLessThanZeroException.class)
    public void 수동_구매_0_이하() {
        Money money = new Money(1000);
        assertThat(InputLottoView.checkPurchaseManualLottoCount(-1, money));
    }

    @Test
    public void 자동_개수_반환() {
        Money money = new Money(14000);

        List<Lotto> lottoNumbers = new ArrayList<>();
        LottoGame lottoGame = new LottoGame(money, lottoNumbers);
        assertThat(lottoGame.getAutoCount()).isEqualTo(14);
    }

    @Test
    public void 수동_개수_반환() {
        Money money = new Money(14000);

        List<Lotto> manualLottoNumbers = new ArrayList<>();
        manualLottoNumbers.add(Lotto.makeAutoLottoNumber());
        manualLottoNumbers.add(Lotto.makeAutoLottoNumber());
        LottoGame lottoGame = new LottoGame(money, manualLottoNumbers);
        assertThat(lottoGame.getManualCount()).isEqualTo(2);
    }

    @Test
    public void 수동_자동_개수_반환() {
        Money money = new Money(14000);

        List<String> manualLottoNumbers = new ArrayList<>();
        for (int i = 0; i < 11; i++) {
            manualLottoNumbers.add(manualLottoTicket);
        }

        List<Lotto> manualLottoNumber = Lotto.makeManualLottoNumbers(manualLottoNumbers);

        LottoGame lottoGame = new LottoGame(money, manualLottoNumber);
        assertThat(lottoGame.getAutoCount()).isEqualTo(3);
        assertThat(lottoGame.getManualCount()).isEqualTo(11);
    }

    @Test
    public void 숫자_일치_개수() {
        Lotto winningLotto = Lotto.makeManualLottoNumber(winningLottoTicket);
        Lotto lotto = Lotto.makeManualLottoNumber(manualLottoTicket);

        assertThat(winningLotto.countMatchLottoNumber(lotto)).isEqualTo(6);
    }

    @Test
    public void 보너스포함() {
        Lotto userLottoNumbers = Lotto.makeManualLottoNumber(manualLottoTicket);
        assertThat(userLottoNumbers.isContainsBonusNumber(6)).isEqualTo(true);
    }

    @Test
    public void 총_수익률() {
        Lotto winningLotto = Lotto.makeManualLottoNumber(winningLottoTicket);
        Lotto lotto = Lotto.makeManualLottoNumber(manualLottoTicket);
        LottoGameResult.setPrizeCount(Rank.valueOf(winningLotto.countMatchLottoNumber(lotto), false));

        assertThat(LottoGameResult.totalYieldMoney()).isEqualTo(Rank.FIRST.getWinningMoney());
    }

}