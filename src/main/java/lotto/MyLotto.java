package lotto;

import java.util.ArrayList;
import java.util.Collections;

public class MyLotto {
	private ArrayList<Integer> myLotto = new ArrayList<>();

	MyLotto(int num) {
		this.myLotto = createRanLotto(num);
	}
	
	MyLotto(ArrayList<Integer> userLottos, int index) {
			this.myLotto = createUserLotto(userLottos, index);
	}

	private ArrayList<Integer> createUserLotto(ArrayList<Integer> userLottos, int index) {
		return new ArrayList<>(userLottos.subList(index, index + 6));
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
