package com.sangco.lotto.model;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

public class LottoGroupTest {
	private LottoGroup lottoGroup;
	
	@Before
	public void setup() {
		ArrayList<String> pickLottoInPerson = new ArrayList<>();
		pickLottoInPerson.add("1,2,3,4,5,6");
		pickLottoInPerson.add("1,2,3,4,5,9");
		pickLottoInPerson.add("1,2,3,4,5,9");
		pickLottoInPerson.add("11,12,13,14,15,19");
		pickLottoInPerson.add("11,12,13,14,15,19");
		pickLottoInPerson.add("11,12,13,14,15,19");
		pickLottoInPerson.add("21,22,23,24,25,29");
		pickLottoInPerson.add("21,22,23,24,25,29");
		pickLottoInPerson.add("21,22,23,24,25,29");
		pickLottoInPerson.add("31,32,33,34,35,39");
		lottoGroup = new LottoGroup(10, pickLottoInPerson);
	}
	
	@Test
	public void TestGetLottoArray() {
		assertEquals(10, lottoGroup.getLottoArray().size());
	}
	
	@Test
	public void TestDoMatchEachLotto() {
		String winNumber = "1,2,3,4,5,6";
		lottoGroup.doMatchEachLotto(new ArrayList<String>(Arrays.asList(winNumber.split(","))), 9);
		assertEquals(1, lottoGroup.getWinLottoState().getMatchCount(Match.FIRST));
		assertEquals(2, lottoGroup.getWinLottoState().getMatchCount(Match.SECOND));
	}
}
