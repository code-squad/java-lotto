package lotto.domain;

import lotto.Util.IntegerListUtil;

import javax.annotation.Nonnull;
import java.util.List;

import static lotto.domain.LottoTicket.LOTTO_NUMBERS_SIZE;
import static lotto.domain.LottoTicket.MAX_LOTTO_NUMBER;

/**
 * Created by Moonchan on 2018. 1. 17..
 */
public class WinningNumber {

    private List<Integer> winningNumber;
    private int bonusNumber;

    public WinningNumber(@Nonnull List<Integer> winningNumber, int bonusNumber) {
        checkValid(winningNumber, bonusNumber);
        this.winningNumber = winningNumber;
        this.bonusNumber = bonusNumber;
    }

    private void checkValid(List<Integer> winningNumber, int bonusNumber) {
        if (winningNumber.size() != LOTTO_NUMBERS_SIZE) {
            throw new IllegalArgumentException("당첨 번호는 " + LOTTO_NUMBERS_SIZE + "개의 숫자여야 합니다.");
        }
        if (IntegerListUtil.hasDuplicate(winningNumber)) {
            throw new IllegalArgumentException("당첨 번호는 중복된 숫자가 없어야 합니다.");
        }
        if (!IntegerListUtil.inRangeClosedAll(winningNumber, 1, MAX_LOTTO_NUMBER)) {
            throw new IllegalArgumentException("당첨 번호에 들어가는 숫자는 1부터 " + MAX_LOTTO_NUMBER + "사이의 숫자여야 합니다.");
        }
        if (bonusNumber < 1 || bonusNumber > MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException("보너스 번호는 1부터 " + MAX_LOTTO_NUMBER + "사이의 숫자여야 합니다.");
        }
        if (winningNumber.contains(bonusNumber)) {
            throw new IllegalArgumentException("보너스 번호 " + bonusNumber + "는 1등번호와 중복될 수 없습니다.");
        }
    }

    public Prize match(LottoTicket userLotto) {
        int diff = LOTTO_NUMBERS_SIZE - userLotto.countMatchNumber(winningNumber);
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
