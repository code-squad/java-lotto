package lotto;

import java.util.ArrayList;

public class WinningLotto { // 기계가 가지고 있는 로또
	private ArrayList<Integer> winningLotto = new ArrayList<>();
	private int bonusBall;

	WinningLotto(ArrayList<Integer> prizeNum, int bonusBall) {
		this.winningLotto = prizeNum;
		addBonusBall(bonusBall);
	}

	private void addBonusBall(int bonusBall) {
		this.bonusBall = bonusBall;
		this.winningLotto.add(bonusBall);

	}

	public ArrayList<Integer> getWinLotto() {
		return this.winningLotto;
	}

	public int getBonusBall() {
		return bonusBall;
	}

}
