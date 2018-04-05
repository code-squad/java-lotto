package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoTicket {
    private static final int LOTTO_MAX_SIZE = 6;

    private List<LottoNo> numbers;

    public LottoTicket(List<LottoNo> numbers) {
        if (!isValid(numbers)) {
            throw new IllegalArgumentException("로또 번호 6개를 입력해 주세요.");
        }
        this.numbers = numbers;
    }

    public static LottoTicket getLottoTicket(List<LottoNo> numbers) {
        return new LottoTicket(numbers);
    }

    public boolean contains(LottoNo number) {
        return numbers.contains(number);
    }

    public boolean isValid(List<LottoNo> numbers) {
        if (numbers.size() != LOTTO_MAX_SIZE) {
            throw new IllegalArgumentException("로또 번호 6개를 입력해 주세요.");
        }
        return true;
    }
}