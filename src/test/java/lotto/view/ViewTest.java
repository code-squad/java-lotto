package lotto.view;

import org.junit.Test;

import lotto.model.Lottos;
import lotto.model.WinLotto;

public class ViewTest {

	@Test
	public void testView() {
		InputView inputView = new InputView();
		Lottos lottos = inputView.inputPrice();
		ResultView resultView = new ResultView(lottos);
		resultView.resultPrint();
	}
	
	@Test
	public void testView2() {
		Lottos lottos = new Lottos();
		lottos.addLotto("1, 2, 3, 4, 5, 6");
		lottos.addLotto("2, 3, 4, 5, 6, 7");
		lottos.addLotto("2, 3, 4, 5, 6, 8");
		lottos.addLotto("3, 4, 5, 6, 7, 8");
		lottos.addLotto("4, 5, 6, 7, 8, 9");
		lottos.addLotto("5, 6, 7, 8, 9, 10");
		lottos.addLotto("6, 7, 8, 9, 10, 11");
		lottos.addLotto("7, 8, 9, 10, 11, 12");
		WinLotto winLotto = new WinLotto("1, 2, 3, 4, 5, 6" , 7);
		
		ResultView resultView = new ResultView(lottos, winLotto);
		resultView.resultPrint();
		
	}
}