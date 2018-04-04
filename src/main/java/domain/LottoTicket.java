package domain;

import java.util.List;

public class LottoTicket extends Lotto implements Bonus {

    public LottoTicket(List<LottoNo> numbers) {
        super(numbers);
    }

    @Override
    public boolean hasBonusNo(LottoNo bonusNo) {
        return super.contains(bonusNo);
    }
}