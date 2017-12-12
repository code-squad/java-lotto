package lotto;

import java.util.ArrayList;

public class WinningLotto {
	private ArrayList<Integer> winningNum = new ArrayList<Integer> ();
	private int bonus;
	
	//생성자.
	public WinningLotto(ArrayList<Integer> winningNum, int bonus) {
		this.winningNum = winningNum;
		this.bonus = bonus;
	}
	
	public ArrayList<Integer> getWinNum() {
		return this.winningNum;
	}
	
	public int getBonusNum() {
		return this.bonus;
	}
}
