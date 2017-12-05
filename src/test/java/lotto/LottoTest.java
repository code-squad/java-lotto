package lotto;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class LottoTest {
	//Lotto 하나를 생성해서, 그 안에 6개의 숫자가 잘 들어가는지 테스트.
	//getNum() method가 잘 작동하는지 까지 확인 가능.
	@Test
	public void makeLottoTest() {
		Lotto lottoTest = new Lotto();
		assertEquals(6, lottoTest.getNum().size());
	}
	
	//matchCount() method 와 findToMatch() method 가 제대로 작동 하는지 테스트.
	@Test
	public void matchCountTest() {
		Lotto lottoTest = new Lotto();
		lottoTest.getNum().clear();
		ArrayList<Integer> winningTest = new ArrayList<Integer> ();
		for (int i = 0; i < 6; i++) {
			lottoTest.getNum().add(i + 2);		//새로 생성한 lotto에 2~7 까지 숫자를 넣는다.
			winningTest.add(i + 1);			//당첨 번호를 1~6까지 숫자를 넣는다.
		}
		assertEquals(6, lottoTest.getNum().size());		//6개의 숫자가 들어갔는지 테스트.
		assertEquals(5, lottoTest.matchCount(winningTest));		//2~6까지 총 5개의 숫자가 일치하는지 확인.
		
	}
}
