package lotto.domain;

import java.util.List;

public class WinningTicket {
    private final LottoTicket lottoTicket;
    private final int bonusNumber;

    public WinningTicket(List<Integer> numbers, int bonusNumber) {
        lottoTicket = new LottoTicket(numbers);
        this.bonusNumber = setBonusNumber(bonusNumber);
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    LottoTicket getLottoTicket() {
        return lottoTicket;
    }

    private int setBonusNumber(int bonusNumber) {
        if (lottoTicket.contains(bonusNumber)) {
            throw new IllegalArgumentException("보너스 번호가 로또 번호와 중복됩니다.");
        }
        return bonusNumber;
    }
}
