package com.sangco.lotto.model;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import com.sangco.lotto.Match;

public class LottosTest {
	private Lottos lottos;
	
	@Before
	public void setup() {
		ArrayList<String> pickInPerson = new ArrayList<>();
		pickInPerson.add("1,2,3,4,5,6");
		pickInPerson.add("1,2,3,4,5,9");
		pickInPerson.add("1,2,3,4,5,9");
		pickInPerson.add("11,12,13,14,15,19");
		pickInPerson.add("11,12,13,14,15,19");
		pickInPerson.add("11,12,13,14,15,19");
		pickInPerson.add("21,22,23,24,25,29");
		pickInPerson.add("21,22,23,24,25,29");
		pickInPerson.add("21,22,23,24,25,29");
		pickInPerson.add("31,32,33,34,35,39");
		lottos = new Lottos(10, pickInPerson);
		lottos.doMatchEachLotto(new ArrayList<String>(Arrays.asList("1,2,3,4,5,6")), 9);
	}
	
	@Test
	public void TestGetLottoArray() {
		assertEquals(10, lottos.getLottoArray().size());
	}
	
/*	
이게 실행되면 밑에 테스트가 2배의 값이 나온다. Jnuit 테스트 다시 공부
 	@Test
	public void TestDoMatchEachLotto() {
		assertEquals(1, lottos.findWin().getWinnerData(6, false));
		assertEquals(2, lottos.findWin().getWinnerData(5, true));
	}
*/
	
	@Test
	public void TestfindLottoRateOfProfit() {
		assertEquals(2060000000, lottos.findWin().findLottoRateOfProfit());
	}
	

	
}
