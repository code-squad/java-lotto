package domain;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private static final int LOTTO_MAX_SIZE = 6;
    private List<LottoNo> numbers;

    public Lotto(List<Integer> numbers) {
        if (!isValid(numbers)) {
            throw new IllegalArgumentException();
        }
        generateLottoNo(numbers);
    }

    private void generateLottoNo(List<Integer> numbers) {
        this.numbers = new ArrayList<>();
        for (Integer number : numbers) {
            LottoNo lottoNo = new LottoNo(number);
            this.numbers.add(lottoNo);
        }
    }

    public boolean isValid(List<Integer> numbers) {
        if (numbers.size() > LOTTO_MAX_SIZE) {
            return false;
        }
        for (Integer number : numbers) {
            if (!(number > 0 && number <= 45)) {
                return false;
            }
        }
        return true;
    }
    // todo 2. 유효성 체크
    //  todo 2-1. size is 6
    //  todo 2-2. 1~45까지인가
    //  todo 2-3. contains method
    // todo 3. 다른 티켓과의 겹치는 숫자
}
