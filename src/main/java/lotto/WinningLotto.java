package lotto;

import java.util.ArrayList;

public class WinningLotto extends Lotto {
	private int bonus;
	
	//생성자.
	public WinningLotto(ArrayList<Integer> winningNum, int bonus) {
		super(winningNum);
		this.bonus = bonus;
	}
	//보너스 번호를 리턴.
	public int getBonusNum() {
		return bonus;
	}
}
