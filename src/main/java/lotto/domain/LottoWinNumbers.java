package lotto.domain;

public class LottoWinNumbers extends Numbers{
	private int bonusNumber;
	
	public LottoWinNumbers(int[] numbers, int bonusNumber) {
		super(numbers);
		this.bonusNumber = bonusNumber;
	}
	
	public int getBonusNumber() {
		return bonusNumber;
	}
}
