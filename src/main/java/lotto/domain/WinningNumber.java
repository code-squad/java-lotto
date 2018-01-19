package lotto.domain;

/**
 * Created by Moonchan on 2018. 1. 17..
 */
public class WinningNumber {
    private LottoNumber winningNumber;
    private int bonusNumber;

    public WinningNumber(LottoNumber winningNumber, int bonusNumber) {
        checkValid(winningNumber, bonusNumber);
        this.winningNumber = winningNumber;
        this.bonusNumber = bonusNumber;
    }

    private void checkValid(LottoNumber winningNumber, int bonusNumber) {
        if(bonusNumber < 1 || bonusNumber > LottoNumber.MAX_NUMBER) {
            throw new IllegalArgumentException("보너스 번호는 1부터 " + LottoNumber.MAX_NUMBER + "사이의 숫자여야 합니다.");
        }
        if(winningNumber.contains(bonusNumber)) {
            throw new IllegalArgumentException("보너스 번호 " + bonusNumber + "는 1등번호와 중복될 수 없습니다.");
        }
    }

    public Prize match(LottoNumber userLotto) {
        int diff = LottoNumber.LOTTO_NUMBERS_SIZE - winningNumber.countMatchNumber(userLotto);
        boolean isMatchBonus = userLotto.contains(bonusNumber);

        for (Prize prize : Prize.values()) {
            if(prize.checkWinningRule(diff) && prize.checkBonusRule(isMatchBonus))
                return prize;
        }
        return Prize.NONE;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
