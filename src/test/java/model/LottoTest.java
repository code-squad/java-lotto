package model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class LottoTest {
	Lotto lotto;
	WinningLotto winningLotto;
	
	@Before
	public void setUp() {
		lotto = new Lotto();
		List<Integer> lottoNums = Arrays.asList(1, 10, 20, 30, 40, 45);
		lotto.setList(lottoNums);
	}
	
	@Test
	public void 로또에_값이_있나() {
		assertEquals(true, lotto.hasNum(1));
		assertEquals(false, lotto.hasNum(2));
		assertEquals(true, lotto.isBonusCommon(1));
		assertEquals(false, lotto.isBonusCommon(2));
	}
	
	@Test
	public void 상금() {
		lotto.addCommonCount(5);
		assertEquals(1500000, lotto.getPrice(2));
		assertEquals(30000000, lotto.getPrice(1));
	}
}
