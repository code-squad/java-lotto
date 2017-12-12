package lotto;

import java.util.ArrayList;
import java.util.Collections;

public class MyLotto {
	private ArrayList<Integer> myLotto = new ArrayList<>();

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

	public Match compareNum(WinningLotto winLotto) {
		Boolean isBonusExist = compareBonusNum(winLotto);
		this.myLotto.retainAll(winLotto.getWinLotto());
		if (isBonusExist && this.myLotto.size() == 5)
			return Match.MATCH_BONUS;
		for (Match match : Match.values())
			if (match.ordinal() + 3 == this.myLotto.size())
				return match;
		return null;
	}

	private Boolean compareBonusNum(WinningLotto winLotto) {
		return this.myLotto.contains(winLotto.getBonusBall());
	}

	@Override
	public String toString() {
		return (myLotto != null ? myLotto : "") + "";
	}

}
