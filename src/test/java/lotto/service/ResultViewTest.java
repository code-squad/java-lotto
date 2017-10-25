package lotto.service;

import org.junit.Test;

import lotto.model.Lottos;
import lotto.view.InputView;
import lotto.view.ResultView;

public class ResultViewTest {
	@Test
	public void testLottoCheck() {
		InputView inputView = new InputView();
		Lottos lottos = inputView.inputPrice();
		ResultView resultView = new ResultView();
		resultView.checkLottosWinner(lottos);
		System.out.println("총 수익률은 " + resultView.incomeRatio(lottos) + "%입니다.");
	}
}
