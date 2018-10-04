package lotto;

import lotto.exception.DuplicatedBonusNumberException;
import lotto.exception.NotEnoughMoneyException;
import lotto.exception.OutOfRangeLottoNumberException;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class WebViewTest {

    private static final String TEST_LOTTO_NUMBER_1 = "1, 2, 3, 4, 5, 6";
    private static final String TEST_LOTTO_NUMBER_2 = "7 ,8 ,9 ,10 ,11 ,12";

    @Test
    public void 돈_입력() {
        Money expected = new Money(1000);
        Money acutal = InputLottoWebView.inputMoney("1000");

        assertThat(expected.rateOfReturn(1000)).isEqualTo(acutal.rateOfReturn(1000));
    }

    @Test(expected = IllegalArgumentException.class)
    public void 돈_입력_실패_문자열() {
        InputLottoWebView.inputMoney("문자열 입력");
    }

    @Test(expected = IllegalArgumentException.class)
    public void 돈_입력_실패_잘못된_숫자() {
        InputLottoWebView.inputMoney("0100");
    }

    @Test
    public void 로또_수동_구매() {
        String acutalInputs = TEST_LOTTO_NUMBER_1 + "\n" + TEST_LOTTO_NUMBER_2;
        List<String> acutal = InputLottoWebView.inputPurchaseManualLotto(acutalInputs, new Money(2000));

        List<String> expected = new ArrayList<>();
        expected.add(TEST_LOTTO_NUMBER_1);
        expected.add(TEST_LOTTO_NUMBER_2);

        assertThat(expected).isEqualTo(acutal);
    }

    @Test(expected = NotEnoughMoneyException.class)
    public void 로또_구매_돈부족() {
        String acutalInputs = TEST_LOTTO_NUMBER_1 + "\n" + TEST_LOTTO_NUMBER_2;
        InputLottoWebView.inputPurchaseManualLotto(acutalInputs, new Money(1000));
    }

    @Test
    public void 로또_보너스_입력() {
        int actual = InputLottoWebView.inputBonus(LottoFactory.makeManualLottoNumber(TEST_LOTTO_NUMBER_1), "7");

        assertThat(7).isEqualTo(actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 로또_보너스_숫자아님() {
        InputLottoWebView.inputBonus(LottoFactory.makeManualLottoNumber(TEST_LOTTO_NUMBER_1), "*");
    }

    @Test(expected = OutOfRangeLottoNumberException.class)
    public void 로또_보너스_숫자범위_벗어남() {
        InputLottoWebView.inputBonus(LottoFactory.makeManualLottoNumber(TEST_LOTTO_NUMBER_1), "100");
    }

    @Test(expected = DuplicatedBonusNumberException.class)
    public void 로또_보너스_겹침() {
        InputLottoWebView.inputBonus(LottoFactory.makeManualLottoNumber(TEST_LOTTO_NUMBER_1), "1");
    }

    @Test
    public void 구매_수량() {
        LottoGame lottoGame = setTestLottoGame("1000", TEST_LOTTO_NUMBER_1);
        String acutal = OutputLottoWebView.printNumberOfLottoPurchase(lottoGame);

        assertThat("1").isEqualTo(acutal);
    }

    @Test
    public void 로또_구매_목록() {
        LottoGame lottoGame = setTestLottoGame("1000", TEST_LOTTO_NUMBER_1);
        List<String> acutal = OutputLottoWebView.printPurchaseLotto(lottoGame);

        assertThat("[" + TEST_LOTTO_NUMBER_1 + "]").isEqualTo(acutal.get(0));
    }

    private LottoGame setTestLottoGame(String inputMoney, String inputManualLottoNumbers) {
        Money money = InputLottoWebView.inputMoney(inputMoney);
        List<String> manualLottoNumbers = InputLottoWebView.inputPurchaseManualLotto(inputManualLottoNumbers, money);
        return new LottoGame(money, LottoFactory.makeManualLottoNumbers(manualLottoNumbers));
    }

}
