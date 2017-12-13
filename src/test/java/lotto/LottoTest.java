package lotto;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class LottoTest {
	//Lotto 하나를 생성해서, 그 안에 6개의 숫자가 잘 들어가는지 테스트.
	//getNum() method가 잘 작동하는지 까지 확인 가능.
	@Test
	public void makeLottoTest() {
		Lotto lottoTest = new AutoLotto();
		assertEquals(6, lottoTest.getNum().size());
	}
	
	//matchCount() method 와 findToMatch() method 가 제대로 작동 하는지 테스트.
	@Test
	public void matchCountTest() {
		Lotto lottoTestOne = new AutoLotto();		//보너스 번호는 안맞고 5개 숫자가 맞는(3등) 로또 생성.
		lottoTestOne.getNum().clear();
		
		Lotto lottoTestTwo = new AutoLotto();		//보너스 번호도 맞고 5개 숫자가 맞는(2등) 로또 생성.
		lottoTestTwo.getNum().clear();
		
		ArrayList<Integer> winningTest = new ArrayList<Integer> ();		//당첨번호 리스트 생성.
		for (int i = 0; i < 6; i++) {
			lottoTestOne.getNum().add(i + 2);		//새로 생성한 lotto에 2~7 까지 숫자를 넣는다.
			lottoTestTwo.getNum().add(i + 2);
			
			winningTest.add(i + 1);			//당첨 번호를 1~6까지 숫자를 넣는다.
		}
		int bonus = 12;
		
		WinningLotto winningLotto = new WinningLotto(winningTest, bonus);
		
		lottoTestTwo.getNum().remove(5);		//마지막 숫자 7 삭제. (보너스 번호로 채우기 위함.)
		lottoTestTwo.getNum().add(bonus);		//보너스 번호 추가.
		
		assertEquals(6, lottoTestOne.getNum().size());		//6개의 숫자가 들어갔는지 테스트.
		assertEquals("RANKTHIRD", lottoTestOne.matchCount(winningLotto).name());		//2~6까지 총 5개가 일치하여 3등이 되었는지 확인.
		
		assertEquals(6, lottoTestTwo.getNum().size());		//6개의 숫자가 들어갔는지 테스트.
		assertEquals("RANKSECOND", lottoTestTwo.matchCount(winningLotto).name());		//2~6까지 총 5개가 일치하고, 보너스 번호도 맞아서 2등이 되었는지 확인.
		
	}
}
