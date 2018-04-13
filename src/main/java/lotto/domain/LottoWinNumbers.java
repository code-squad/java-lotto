package lotto.domain;

import lotto.util.ExceptionUtils;

public class LottoWinNumbers{
	private LottoNumbers winNumbers;
	private LottoNumber bonusNumber;

	public LottoWinNumbers(LottoNumbers winNumbers, LottoNumber bonusNumber) {
		this.winNumbers = winNumbers;
		validateBonusNumber(bonusNumber);
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

	private void validateBonusNumber(LottoNumber bonusNumber) {
		if(winNumbers.contains(bonusNumber)) {
			ExceptionUtils.throwIllegalArgumentException(LottoWinNumbers.class, "보너스 번호는 당첨번호 6개의 값이 아니어야 합니다.");
		}
	}
}
