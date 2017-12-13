package lotto;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class LottosTest {
	//Lottos의 get() 메소드 / add() 메소드가 제대로 작동하는지 확인.
	@Test
	public void makeLottos() {
		Lottos lottos = new Lottos();
		lottos.add(new AutoLotto());
		assertEquals(1, lottos.get().size());		//로또 1장이 생성 되었는지 확인.
		assertEquals(6, lottos.get().get(0).getNum().size());		//생성된 로또가 6개의 번호가 들어가 있는지 확인
	}
	//티켓을 구매하고 나서, 그 티켓이 당첨번호와 얼마나 일치하여 어떤 Match가 되는지 확인하는 메소드.
	@Test
	public void makeMatchListTest() {
		ArrayList<Integer> num = new ArrayList<Integer> ();
		for (int i = 0; i < 6; i++) {
			num.add(i + 1);		//[1, 2, 3, 4, 5, 6] ArrayList
		}
		Lotto testLotto = new Lotto(num);		//[1, 2, 3, 4, 5, 6] Lotto
		
		Lottos lottos = new Lottos();
		lottos.add(testLotto);		//lottos 에 lotto 1개 추가.
		
		ArrayList<Integer> winningNum = new ArrayList<Integer> ();
		
		for (int i = 0; i < 6; i++) {
			winningNum.add(i + 2);		//[2, 3, 4, 5, 6, 7] winningNum ArrayList
		}
		
		int bonus = 1;		//bonus number is 1. / [2, 3, 4, 5, 6]과 보너스 넘버 1이 일치하여 2등이 되어야 한다.
		
		WinningLotto winningLotto = new WinningLotto(winningNum, bonus);
		ArrayList<Match> matchList = lottos.makeMatchList(winningLotto);		//1장의 티켓이 어떤 Match 와 일치하는지 담겨진 ArrayList를 받아준다.
		assertEquals("RANKSECOND", matchList.get(0).name());		//matchList에 들어가 있는 Match 의 이름이 "RANKSECOND" (2등) 인지 확인해본다.
	}
	//최종 결과 ArrayList가 잘 생성 되는지(처음 생성만) 확인하는 메소드.
	@Test
	public void makeResultTest() {
		Lottos lottosTest = new Lottos();
		
		ArrayList<MatchingResult> matchingResult = lottosTest.makeResult();
		
		assertEquals(5, matchingResult.size());		//size 5짜리 ArrayList가 제대로 만들어 졌는지 확인.
		for (int i = 0; i < matchingResult.size(); i++) {
			assertEquals(0, matchingResult.get(i).returnCount());		//초기값(카운트값)이 0이 잘 들어가 있는지 확인.
		}
	}
	//결과값이 제대로 정리 되서 [3개 맞은 갯수, 4개 맞은 갯수, 5개 맞은 갯수, 6개 맞은 갯수] 가 잘 나오는지 확인.
	@Test
	public void fillResultTest() {
		ArrayList<Integer> num1 = new ArrayList<Integer> ();
		ArrayList<Integer> num2 = new ArrayList<Integer> ();
		ArrayList<Integer> num3 = new ArrayList<Integer> ();
		ArrayList<Integer> num4 = new ArrayList<Integer> ();
		
		for (int i = 0; i < 6; i++) {
			num1.add(i + 1);
			num2.add(i + 2);
			num3.add(i + 3);
			num4.add(i + 4);
		}
		
		Lottos lottos = new Lottos();
		Lotto allRightLotto = new Lotto(num1);		//[1, 2, 3, 4, 5, 6] 을 가진 1등 로또.
		Lotto fiveRightLotto = new Lotto(num2);		//[2, 3, 4, 5, 6, 7] 을 가진 3등 로또.
		Lotto fiveAndBonusLotto = new Lotto(num2);	//[2, 3, 4, 5, 6, 7]
		fiveAndBonusLotto.getNum().remove(5);		//[2, 3, 4, 5, 6]
		fiveAndBonusLotto.getNum().add(12);			//[2, 3, 4, 5, 6, 12] 을 가진 2등 로또.
		Lotto fourRightLotto = new Lotto(num3);		//[3, 4, 5, 6, 7, 8] 을 가진 4등 로또.
		Lotto threeRightLotto = new Lotto(num4);		//[4, 5, 6, 7, 8, 9] 을 가진 5등 로또.
		
		lottos.add(allRightLotto);
		lottos.add(fiveAndBonusLotto);
		lottos.add(fiveRightLotto);
		lottos.add(fourRightLotto);
		lottos.add(threeRightLotto);		//5개의 로또를 lottos 객체 안에 넣는다.
		
		ArrayList<Integer> winningList = new ArrayList<Integer> ();
		for (int i = 0; i < 6; i++) {
			winningList.add(i + 1);		//[1, 2, 3, 4, 5, 6] 을 당첨 번호로 지정.
		}
		
		int bonus = 12;		//보너스 번호 12 추가.
		
		WinningLotto winningLotto = new WinningLotto(winningList, bonus);
		ArrayList<Match> matchList = lottos.makeMatchList(winningLotto);		//matchingList 를 만들어준다.
		ArrayList<MatchingResult> result = new ArrayList<MatchingResult> ();
		Lottos.fillResult(matchList, result);		//최종 MatchingResult 리스트를 만들어준다.
		
		ArrayList<MatchingResult> resultTest = new ArrayList<MatchingResult> ();
		for(Match match: Match.values()) {
			resultTest.add(new MatchingResult(match));
		}
		for (int i = 0; i < resultTest.size(); i++) {
			resultTest.get(i).match();		//3개, 4개, 5개, 5개 + 보너스, 6개 맞은것이 모두 1개씩 증가해야 한다. 이를 테스트 하기위한 리스트 만듬.
		}
		for (int i = 0; i < result.size(); i++) {
			assertEquals(resultTest.get(i), result.get(i));		//각각의 MatchingResult 항목마다 같은지 테스트.
		}
	}
}
