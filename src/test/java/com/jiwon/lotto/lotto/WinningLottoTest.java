package com.jiwon.lotto.lotto;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class WinningLottoTest {
	
	WinningLotto winningLotto;
	Lotto lotto;
	
	@Before
	public void setUp() {
		List<Integer> numbers = new ArrayList<>(Arrays.asList(1,2,3,4,5,6));
		winningLotto  = new WinningLotto(numbers);
		List<Integer> numbers1 = new ArrayList<>(Arrays.asList(7,8,9,10,11,12));
		lotto = new Lotto(numbers1);
	}
	@Test
	public void 보너스볼과_일치하는지_여부_테스트() {
		setUp();
		int bonusNum = 7;
//		winningLotto.setBonusNum(bonusNum);
		assertEquals(true, winningLotto.isMatchUpWithBonus(lotto));
		
	}
	@Test
	public void 당첨로또와_후보로또_비교해_일치하는_갯수_반환() {
		
		assertEquals(0, winningLotto.compare(lotto));
	}
	

}
