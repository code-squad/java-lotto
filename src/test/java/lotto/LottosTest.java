package lotto;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class LottosTest {
	//Lottos의 get() 메소드 / add() 메소드가 제대로 작동하는지 확인.
	@Test
	public void makeLottos() {
		Lottos lottos = new Lottos();
		lottos.add(new Lotto());
		assertEquals(1, lottos.get().size());		//로또 1장이 생성 되었는지 확인.
		assertEquals(6, lottos.get().get(0).getNum().size());		//생성된 로또가 6개의 번호가 들어가 있는지 확인
	}
	//결과값이 제대로 정리 되서 [3개 맞은 갯수, 4개 맞은 갯수, 5개 맞은 갯수, 6개 맞은 갯수] 가 잘 나오는지 확인.
	@Test
	public void makeResultTest() {
		Lottos lottos = new Lottos();
		Lotto allRightLotto = new Lotto();
		Lotto fiveAndBonusLotto = new Lotto();
		Lotto fiveRightLotto = new Lotto();
		Lotto fourRightLotto = new Lotto();
		Lotto threeRightLotto = new Lotto();		//로또 5개를 만든다.
		
		allRightLotto.getNum().clear();
		fiveAndBonusLotto.getNum().clear();
		fiveRightLotto.getNum().clear();
		fourRightLotto.getNum().clear();
		threeRightLotto.getNum().clear();		//생성 된 5개의 로또를 초기화 시켜준다.
		
		for (int i = 0; i < 6; i++) {
			allRightLotto.getNum().add(i + 1);		//[1, 2, 3, 4, 5, 6] 이 들어간 로또 생성. 당첨번호와 일치하는 로또.
			fiveAndBonusLotto.getNum().add(i + 2);	//[2, 3, 4, 5, 6, 7] 이 들어간 로또 생성. 5개 일치 -> 추 후 1값 빼서 보너스 번호로 바꿀 예정.
			fiveRightLotto.getNum().add(i + 2);		//[2, 3, 4, 5, 6, 7] 이 들어간 로또 생성. 5개가 일치하는 로또.
			fourRightLotto.getNum().add(i + 3);		//[3, 4, 5, 6, 7, 8] 이 들어간 로또 생성. 4개가 일치하는 로또.
			threeRightLotto.getNum().add(i + 4);		//[4, 5, 6, 7, 8, 9] 이 들어간 로또 생성. 3개가 일치하는 로또.
		}
		fiveAndBonusLotto.getNum().remove(5);		//보너스 번호를 넣기 위해 마지막 번호는 지운다. -> [2, 3, 4, 5, 6] 으로 상태 변경.
		fiveAndBonusLotto.getNum().add(12);		//보너스 번호 12를 미리 넣어 둔다. -> [2, 3, 4, 5, 6, 12] 로 상태 변경됨.
		
		lottos.add(allRightLotto);
		lottos.add(fiveAndBonusLotto);
		lottos.add(fiveRightLotto);
		lottos.add(fourRightLotto);
		lottos.add(threeRightLotto);		//5개의 로또를 lottos 객체 안에 넣는다.
		
		ArrayList<Integer> winningList = new ArrayList<Integer> ();
		for (int i = 0; i < 6; i++) {
			winningList.add(i + 1);		//[1, 2, 3, 4, 5, 6] 을 당첨 번호로 지정.
		}
		
		int bonus = 12;		//보너스 번호 12 추가. -> [1, 2, 3, 4, 5, 6, 12] 상태로 변환.
		
		ArrayList<MatchingResult> resultTest = new ArrayList<MatchingResult> ();
		for(Match match: Match.values()) {
			resultTest.add(new MatchingResult(match));
		}
		for (int i = 0; i < resultTest.size(); i++) {
			resultTest.get(i).match();		//3개, 4개, 5개, 5개 + 보너스, 6개 맞은것이 모두 1개씩 증가해야 한다. 이를 테스트 하기위한 리스트 만듬.
		}
		ArrayList<Match> matchList = lottos.makeMatchList(winningList, bonus);
		ArrayList<MatchingResult> compareResult = lottos.makeResult();
		Lottos.fillResult(matchList, compareResult);
		
		for (int i = 0; i < resultTest.size(); i++) {
			assertEquals(resultTest.get(i).returnMatch(), compareResult.get(i).returnMatch());		//각각의 매치가 같은 매치인지 테스트.
			assertEquals(resultTest.get(i).returnCount(), compareResult.get(i).returnCount());		//예측한 [1, 1, 1, 1, 1]이 제대로 나오는지 테스트.
		}
	}
}
