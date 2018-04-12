package lotto.domain;

public class LottoWinNumbers{
	private Numbers winNumbers;
	private int bonusNumber;

	public static final int BONUS_NUMBER_MAX_VALUE = 45;
	
	public LottoWinNumbers(Numbers winNumbers, int bonusNumber) {
		if(bonusNumber > BONUS_NUMBER_MAX_VALUE || bonusNumber < 0) {
			throw new IllegalArgumentException("보너스 번호는 1~45 사이 값이어야 합니다.");
		}
		if(winNumbers.contains(bonusNumber)) {
			throw new IllegalArgumentException("보너스 번호는 당첨번호 6개의 값이 아니어야 합니다.");
		}
		this.winNumbers = winNumbers;
		this.bonusNumber = bonusNumber;
	}
	
	public LottoWinType match(Lotto lotto) {
		int matchCount = (int) winNumbers.stream()
				.filter(winNumber -> lotto.contains(winNumber))
				.count();
		if(matchCount == 4) {
			return LottoWinType.SECOND;
		}
		return LottoWinType.valueOf(matchCount);
	}
}
