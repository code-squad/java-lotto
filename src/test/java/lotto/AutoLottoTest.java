package lotto;

import static org.junit.Assert.*;

import org.junit.Test;

public class AutoLottoTest {
	//생성자 Test. (size)
	@Test
	public void makeAutoLottoTest() {
		AutoLotto autoLotto = new AutoLotto();
		
		assertEquals(6, autoLotto.getNum().size());
	}
}
