package lotto;

import java.util.ArrayList;
import java.util.Collections;

public class MyLotto extends Lotto {
	private ArrayList<Integer> myLotto = new ArrayList<>();

	public ArrayList<Integer> getMyLotto() {
		return myLotto;
	}

	MyLotto(int num) {
		super(createRanLotto(num));
		this.myLotto = createRanLotto(num);
	}

	MyLotto(ArrayList<Integer> userLotto) {
		super(userLotto);
		this.myLotto = userLotto;
	}

	private static ArrayList<Integer> wholeLottoNum() {
		ArrayList<Integer> wholeNum = new ArrayList<>();
		for (int i = 1; i < 46; i++) {
			wholeNum.add(i);
		}
		return wholeNum;
	}

	public static ArrayList<Integer> createRanLotto(int num) {
		ArrayList<Integer> wholeNum = wholeLottoNum();
		Collections.shuffle(wholeNum);

		return new ArrayList<>(wholeNum.subList(0, 6));
	}

	public Rank compareNum(WinningLotto winLotto) {
		Boolean isBonus = winLotto.compareBonusNum(this.myLotto);
		this.myLotto.retainAll(winLotto.getWinLotto());
		return Rank.valueOf(this.myLotto.size(), isBonus);
	}

	@Override
	public String toString() {
		return (myLotto != null ? myLotto : "") + "";
	}

}
