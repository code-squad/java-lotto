package lotto.view;

import org.junit.Test;

import lotto.model.Lottos;

public class ViewTest {

	@Test
	public void testView() {
		InputView inputView = new InputView();
		Lottos lottos = inputView.inputPrice();
		ResultView resultView = new ResultView(lottos);
		resultView.resultPrint();
	}
}