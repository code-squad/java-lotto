package lotto.domain;

public class LottoWinNumbers{
	private Numbers winNumbers;
	private int bonusNumber;
	
	public LottoWinNumbers(int[] winNumbers, int bonusNumber) {
		this.winNumbers = new Numbers(winNumbers);
		this.bonusNumber = bonusNumber;
	}
	
	public Numbers getWinNumbers() {
		return winNumbers;
	}
	
	public int getBonusNumber() {
		return bonusNumber;
	}
}
