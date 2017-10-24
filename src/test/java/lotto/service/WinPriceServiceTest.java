package lotto.service;

import org.junit.Test;

import lotto.model.Lottos;

public class WinPriceServiceTest {
	@Test
	public void testLottoCheck() {
		LottosService lottosService = new LottosService();
		Lottos lottos = lottosService.inputPrice();
		WinPriceService winPriceService = new WinPriceService();
		winPriceService.checkLottosWinner(lottos);
		System.out.println("총 수익률은 " + winPriceService.incomeRatio(lottos) + "%입니다.");
	}
}
