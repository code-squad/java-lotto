package domain.lotto;

import DTO.LottoNumbers;
import DTO.WinningResult;
import enums.WinningRules;
import utils.StringParseUtil;

import java.util.ArrayList;
import java.util.List;

public class LottoTicket {

    public static final Integer PRICE = 1000;
    private LottoNumbers numbers;

    public LottoTicket() {
    }

    public LottoTicket(LottoNumbers numbers) {
        this.numbers = numbers;
        this.numbers.sortingNumber();
    }

    public LottoTicket insertNumber(String text) {
        if (text.isEmpty()) {
            return null;
        }

        List<LottoNumber> newNumbers = new ArrayList<>();

        for (String number : StringParseUtil.parsingTextNumber(text)) {
            newNumbers.add(new LottoNumber(number));
        }

        this.numbers = new LottoNumbers(newNumbers);

        this.numbers.sortingNumber();

        return this;
    }

    public WinningRules winningMaching(LottoNumbers winningNumbers) {
        Integer count = 0;

        for (LottoNumber winningNumber : winningNumbers.getNumbers()) {
            count += this.numbers.isHitNumber(winningNumber);
        }

        return WinningResult.findByMatchCount(count);
    }

    public LottoNumbers getNumbers() {
        return this.numbers;
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
