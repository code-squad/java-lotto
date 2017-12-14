package lotto;

import java.util.ArrayList;

public class WinningLotto { // 기계가 가지고 있는 로또
	private ArrayList<Integer> winningLotto = new ArrayList<>();
	private int bonusBall;

	WinningLotto(ArrayList<Integer> prizeNum, int bonusBall) {
		this.winningLotto = prizeNum;
		this.bonusBall = bonusBall;
	}


	public ArrayList<Integer> getWinLotto() {
		return this.winningLotto;
	}


	public Boolean compareBonusNum(ArrayList<Integer> myLotto) {
		return myLotto.contains(this.bonusBall);
	}

}
