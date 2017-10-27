package lotto.service;

import org.junit.Test;

import lotto.model.Lottos;
import lotto.model.WinLotto;

public class LottoCheckerTest {
	private Lottos lottos;
	private WinLotto winLotto;
	private LottoChecker lottoChecker;

	public void testSetLottoChecker() {
		lottos = new Lottos();
		lottos.purchasePrice(8000);
		for (int i = 0; i < lottos.size(); i++) {
			System.out.println(lottos.getString(i));
		}
		System.out.println();
		winLotto = new WinLotto();
		System.out.println(winLotto.getString());
		lottoChecker = new LottoChecker(lottos, winLotto);
	}

	@Test
	public void testLottoCheck() {
		testSetLottoChecker();
		lottoChecker.lottoCheck();
		System.out.println(lottoChecker.getTotalSumPrice());
	}

	@Test
	public void testCheckLottosWinner() {
		testSetLottoChecker();
		lottoChecker.checkLottosWinner();
	}
}
