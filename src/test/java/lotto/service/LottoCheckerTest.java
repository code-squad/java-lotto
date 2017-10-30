package lotto.service;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import lotto.model.Lotto;
import lotto.model.Lottos;
import lotto.model.NomalLotto;
import lotto.model.WinLotto;

public class LottoCheckerTest {
	private Lottos lottos;
	private WinLotto winLotto;
	private LottoChecker lottoChecker;

	private void testSetLottoChecker() {
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
	public void testCompareBonusBall() {
		WinLotto winLotto = new WinLotto("1, 2, 3, 4, 5, 6", 7);
		Lotto lotto = new NomalLotto("2, 3, 4, 5, 6, 7");
		assertTrue(winLotto.compareBonusBall(lotto));
	}
}
