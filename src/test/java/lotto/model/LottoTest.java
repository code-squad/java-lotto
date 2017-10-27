package lotto.model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import lotto.view.InputView;

public class LottoTest {
	private Lotto lotto = new NomalLotto();
	
	@Test
	public void testLotto() {
		Lotto lotto1 = new NomalLotto("1, 2, 3, 4, 5, 6");
		Lotto lotto2 = new NomalLotto("4, 5, 6, 7, 8, 9");
		assertEquals(lotto1.getNumber(1), 2);
		assertEquals(lotto2.getNumber(1), 5);
		assertEquals(lotto1.matchingNumber(2), true);
		assertEquals(lotto1.matchingNumber(9), false);
		
		assertEquals(lotto1.compareLottoCount(lotto2), 3);
	}

	@Test
	public void testPurchaseAuto() {
		System.out.println(lotto.getString());
	}
	
	@Test
	public void testInputView() {
		InputView inputView = new InputView();
		inputView.inputPrice();
	}
}