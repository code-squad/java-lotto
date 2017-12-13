package lotto;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class WinningLottoTest {
	//생성자 test. (bonus number / size)
	@Test
	public void winningLottoTest() {
		ArrayList<Integer> num = new ArrayList<Integer> ();
		for (int i = 0; i < 6; i++) {
			num.add(i);
		}
		
		int bonus = 12;
		
		WinningLotto winningLotto = new WinningLotto(num, bonus);
		
		assertEquals(12, winningLotto.getBonusNum());
		assertEquals(6, winningLotto.getNum().size());
	}

}
