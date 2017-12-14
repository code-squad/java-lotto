package lotto;

import static lotto.Rank.RANK_BONUS;
import static lotto.Rank.RANK_FIRST;
import static lotto.Rank.RANK_SECOND;
import static lotto.Rank.RANK_THIRD;
import static lotto.Rank.RANK_FOURTH;

import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import java.util.HashMap;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class LottosTest {
	Lottos lottos;
	WinningLotto winLotto;
	MyLotto myLotto;
	HashMap<Rank, Integer> result = new HashMap<>();
	ArrayList<Integer> prizeNum;
	ArrayList<Integer> userLotto = new ArrayList<>();;
	ArrayList<ArrayList<Integer>> userLottos = new ArrayList<>();

	@Before
	public void setUp() {
		int bonusBall = 1;

		int[] winLottoArray = { 2, 3, 4, 5, 6, 7 };
		prizeNum = new ArrayList<>();
		for (int i = 0; i < winLottoArray.length; i++)
			prizeNum.add(winLottoArray[i]);

		winLotto = new WinningLotto(prizeNum, bonusBall);
	}

	@Test
	public void compareNumBonus() {
		int[] manualLotto = { 1, 2, 3, 4, 5, 6 };
		for (int i = 0; i < manualLotto.length; i++)
			userLotto.add(manualLotto[i]);
		userLottos.add(userLotto);
		myLotto = new MyLotto(userLotto);
		lottos = new Lottos(userLottos, 1);
		assertEquals(RANK_BONUS, myLotto.compareNum(winLotto));
	}

	@Test
	public void compareNumThree() {
		int[] manualLotto = { 4, 5, 6, 8, 9, 10 };
		for (int i = 0; i < manualLotto.length; i++)
			userLotto.add(manualLotto[i]);
		userLottos.add(userLotto);
		myLotto = new MyLotto(userLotto);
		lottos = new Lottos(userLottos, 1);
		assertEquals(RANK_FOURTH, myLotto.compareNum(winLotto));
	}

	@Test
	public void compareNumFour() {
		int[] manualLotto = { 3, 4, 5, 6, 8, 9 };
		for (int i = 0; i < manualLotto.length; i++)
			userLotto.add(manualLotto[i]);
		userLottos.add(userLotto);
		myLotto = new MyLotto(userLotto);
		lottos = new Lottos(userLottos, 1);
		assertEquals(RANK_THIRD, myLotto.compareNum(winLotto));
	}

	@Test
	public void compareNumFive() {
		int[] manualLotto = { 2, 3, 4, 5, 6, 8 };
		for (int i = 0; i < manualLotto.length; i++)
			userLotto.add(manualLotto[i]);
		userLottos.add(userLotto);
		myLotto = new MyLotto(userLotto);
		lottos = new Lottos(userLottos, 1);
		assertEquals(RANK_SECOND, myLotto.compareNum(winLotto));
	}

	@Test
	public void compareNumAll() {
		int[] manualLotto = { 2, 3, 4, 5, 6, 7 };
		for (int i = 0; i < manualLotto.length; i++)
			userLotto.add(manualLotto[i]);
		userLottos.add(userLotto);
		myLotto = new MyLotto(userLotto);
		lottos = new Lottos(userLottos, 1);
		assertEquals(RANK_FIRST, myLotto.compareNum(winLotto));
	}
	

	@Test
	public void compareLottosBonus() { // compareLotto의 경우의 수만큼 test case 작성 // 3,4,5,6,bonus
		int[] manualLotto = { 1, 2, 3, 4, 5, 6 };
		for (int i = 0; i < manualLotto.length; i++)
			userLotto.add(manualLotto[i]);
		userLottos.add(userLotto);
		myLotto = new MyLotto(userLotto);
		lottos = new Lottos(userLottos, 1);
		
		result.put(RANK_BONUS, 1);
		assertEquals(result.get(RANK_BONUS), lottos.compareLotto(winLotto).get(RANK_BONUS));
	}
	@Test
	public void compareLottosThree(){
		int[] manualLotto = { 4, 5, 6, 8, 9, 10 };
		for (int i = 0; i < manualLotto.length; i++)
			userLotto.add(manualLotto[i]);
		userLottos.add(userLotto);
		myLotto = new MyLotto(userLotto);
		lottos = new Lottos(userLottos, 1);
		
		result.put(RANK_FOURTH, 1);
		assertEquals(result.get(RANK_FOURTH), lottos.compareLotto(winLotto).get(RANK_FOURTH));
	}
	
	@Test
	public void compareLottosFour(){
		int[] manualLotto = { 3, 4, 5, 6, 8, 9 };
		for (int i = 0; i < manualLotto.length; i++)
			userLotto.add(manualLotto[i]);
		userLottos.add(userLotto);
		myLotto = new MyLotto(userLotto);
		lottos = new Lottos(userLottos, 1);
		
		result.put(RANK_THIRD, 1);
		assertEquals(result.get(RANK_THIRD), lottos.compareLotto(winLotto).get(RANK_THIRD));
	}
	
	@Test
	public void compareLottosFive(){
		int[] manualLotto = { 2, 3, 4, 5, 6, 8 };
		for (int i = 0; i < manualLotto.length; i++)
			userLotto.add(manualLotto[i]);
		userLottos.add(userLotto);
		myLotto = new MyLotto(userLotto);
		lottos = new Lottos(userLottos, 1);
		
		result.put(RANK_SECOND, 1);
		assertEquals(result.get(RANK_SECOND), lottos.compareLotto(winLotto).get(RANK_SECOND));
	}
	
	@Test
	public void compareLottosAll(){
		int[] manualLotto = { 2, 3, 4, 5, 6, 7 };
		for (int i = 0; i < manualLotto.length; i++)
			userLotto.add(manualLotto[i]);
		userLottos.add(userLotto);
		myLotto = new MyLotto(userLotto);
		lottos = new Lottos(userLottos, 1);
		
		result.put(RANK_FIRST, 1);
		assertEquals(result.get(RANK_FIRST), lottos.compareLotto(winLotto).get(RANK_FIRST));
	}
	

	@After
	public void tearDown() {
		myLotto = null;
		lottos = null;
		winLotto = null;
	}
}
