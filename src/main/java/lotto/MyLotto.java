package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MyLotto {
	private ArrayList<Integer> myLotto = new ArrayList<>();
	private static final int BONUSBALL_SCORE = 100;

	MyLotto(int num) {
		this.myLotto = createRanLotto(num);
	}

	private ArrayList<Integer> wholeLottoNum() {
		ArrayList<Integer> wholeNum = new ArrayList<>();
		for (int i = 1; i < 46; i++) {
			wholeNum.add(i);
		}
		return wholeNum;
	}

	public ArrayList<Integer> createRanLotto(int num) {
		ArrayList<Integer> wholeNum = wholeLottoNum();
		Collections.shuffle(wholeNum);

		return new ArrayList<>(wholeNum.subList(0, 6));
	}

	public int compareNum(WinningLotto winLotto) {
		this.myLotto.retainAll(winLotto.getWinLotto());
		if (this.myLotto.contains(winLotto.getBonusBall()) && this.myLotto.size() == 6)
			return BONUSBALL_SCORE;
		return this.myLotto.size();
	}

	@Override
	public String toString() {
		return (myLotto != null ? myLotto : "") + "";
	}

}
