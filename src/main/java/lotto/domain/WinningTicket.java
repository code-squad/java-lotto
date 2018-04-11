package lotto.domain;

import java.util.List;

public class WinningTicket extends LottoTicket {
    private final int bonusNumber;

    public WinningTicket(List<Integer> numbers, int bonusNumber) {
        super(numbers);
        this.bonusNumber = setBonusNumber(bonusNumber);
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    private int setBonusNumber(int bonusNumber) {
        if (contains(bonusNumber)) {
            throw new IllegalArgumentException("보너스 번호가 로또 번호와 중복됩니다.");
        }

        return bonusNumber;
    }
}
