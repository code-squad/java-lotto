package domain.lotto;

import dto.LottoNumbers;
import dto.ParsingLottoNumbers;
import dto.WinningResult;
import enums.WinningRules;

import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class LottoTicket {

    public static final Integer PRICE = 1000;
    private LottoNumbers lottoNumbers;

    public LottoTicket(String text) {
        if (text.isEmpty()) {
            return;
        }

        SortedSet<LottoNumber> newNumbers = new TreeSet<>();

        for (String number : new ParsingLottoNumbers(text).getNumbers()) {
            newNumbers.add(new LottoNumber(number));
        }

        this.lottoNumbers = new LottoNumbers(newNumbers);
    }

    public LottoTicket(LottoNumbers lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public WinningRules matching(LottoTicket ticket, LottoNumber bonusNumber) {
        Integer count = 0;
        LottoNumbers lottoNumbers = ticket.getLottoNumbers();

        for (LottoNumber winningNumber : lottoNumbers.getNumbers()) {
            count += this.lottoNumbers.isHitNumber(winningNumber);

            if(count == 5 && lottoNumbers.isHitNumber(bonusNumber) == 1){
                return WinningRules.BONUS_MATCHING;
            }
        }

        return WinningResult.findByMatchCount(count);
    }

    public LottoNumbers getLottoNumbers() {
        return lottoNumbers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LottoTicket that = (LottoTicket) o;

        return lottoNumbers.equals(that.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return lottoNumbers.hashCode();
    }

    @Override
    public String toString() {
        return this.lottoNumbers.toString();
    }
}
