package lotto;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class MatchingResultTest {
	//count값을 증가시켜주는 match() 메소드 동작 확인.
	@Test
	public void matchTest() {
		Lottos lottos = new Lottos();
		ArrayList<MatchingResult> resultTest = lottos.makeResult();		//MatchingResult 형의 ArrayList 생성.
		for (int i = 0; i < resultTest.size(); i++) {
			assertEquals(0, resultTest.get(i).returnCount());		//count 값들이 모두 0으로 초기화 되었는지 확인.
		}
		for (int i = 0; i < resultTest.size(); i++) {
			resultTest.get(i).match();		//match() 메소드를 이용하여 count 수 증가.
		}
		for (int i = 0; i < resultTest.size(); i++) {
			assertEquals(1, resultTest.get(i).returnCount());		//count값이 모두 1씩 증가했는지 확인.
		}	
	}
	
	//match 가 일치할 때, True / 불 일치할 때, False를 리턴하는 isMatch 메소드 테스트.
	@Test
	public void isMatchTest() {
		Lottos lottos = new Lottos();
		ArrayList<MatchingResult> resultTest = lottos.makeResult();		//MatchingResult 형의 ArrayList 생성.
		
		ArrayList<Integer> num1 = new ArrayList<Integer> ();
		ArrayList<Integer> num2 = new ArrayList<Integer> ();
		ArrayList<Integer> num3 = new ArrayList<Integer> ();
		
		for (int i = 0; i < 6; i++) {
			num1.add(i + 1);		//1, 2, 3, 4, 5, 6
			num2.add(i + 2);		//2, 3, 4, 5, 6, 7
			num3.add(i + 3);		//3, 4, 5, 6, 7, 8
		}
		
		Lotto lotto1 = new Lotto(num1);
		Lotto lotto2 = new Lotto(num2);
		Lotto lotto3 = new Lotto(num3);
		
		lottos.add(lotto1);
		lottos.add(lotto2);
		lottos.add(lotto3);
		
		ArrayList<Integer> winningNum = new ArrayList<Integer> ();
		
		for (int i = 0; i < 6; i++) {
			winningNum.add(i + 1);		//winningNum = [1, 2, 3, 4, 5, 6]
		}
		
		ArrayList<Match> matchList = lottos.makeMatchList(winningNum, 12);
		
		assertTrue(resultTest.get(4).isMatch(matchList.get(0)));		//matchList 0번째와 resultTest 4번째는 1등 로또 이므로 같아야 한다.
		assertTrue(resultTest.get(2).isMatch(matchList.get(1)));		//matchList 1번째와 resultTest 2번째는 3등 로또 이므로 같아야 한다.
		assertTrue(resultTest.get(1).isMatch(matchList.get(2)));		//matchList 2번째와 resultTest 1번째는 4등 로또 이므로 같아야 한다.
	}

}
