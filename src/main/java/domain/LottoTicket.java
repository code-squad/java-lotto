package domain;

import java.util.List;

public class LottoTicket extends Lotto implements Bonus{
    private static final int LOTTO_SIZE = 6;

    public LottoTicket(List<Integer> numbers) throws Exception {
        super(numbers);
    }

    @Override
    public boolean hasBonusNo(LottoNo bonusNo) {
        return super.contains(bonusNo);
    }

//    public int getMatchedCount(Lotto anotherLottoTicket) {
//        List<Integer> winningNumbers = winningLottoTicket.getNumbers();
//        this.numbers.removeAll(winningNumbers);
//        return LOTTO_SIZE - numbers.size();
//        anotherLottoTicket.getIntersect
//        return 0;
//    }
}