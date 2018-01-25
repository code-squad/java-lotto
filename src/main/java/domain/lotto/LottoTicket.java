package domain.lotto;

import dto.LottoNumbers;
import dto.ParsingLottoNumbers;
import dto.WinningResult;
import enums.WinningRules;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

public class LottoTicket {

    public static final Integer PRICE = 1000;
    private LottoNumbers numbers;

    public LottoTicket(String text) {
        if (text.isEmpty()) {
            return;
        }

        SortedSet<LottoNumber> newNumbers = new TreeSet<>();

        for (String number : new ParsingLottoNumbers(text).getNumbers()) {
            newNumbers.add(new LottoNumber(number));
        }

        this.numbers = new LottoNumbers(newNumbers);
    }

    public LottoTicket(LottoNumbers numbers) {
        this.numbers = numbers;
    }

    public WinningRules matching(LottoTicket ticket) {
        Integer count = 0;

        for (LottoNumber winningNumber : ticket.numbers.getNumbers()) {
            count += this.numbers.isHitNumber(winningNumber);
        }

        return WinningResult.findByMatchCount(count);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LottoTicket that = (LottoTicket) o;

        return numbers.equals(that.numbers);
    }

    @Override
    public int hashCode() {
        return numbers.hashCode();
    }

    @Override
    public String toString() {
        return this.numbers.toString();
    }
}
