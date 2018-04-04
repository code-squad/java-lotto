package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
        if (numbers.size() != LOTTO_MAX_SIZE) {
            throw new IllegalArgumentException("로또 번호 6개를 입력해 주세요.");
        }
        for (Integer number : numbers) {
            if (!(number > 0 && number <= 45)) {
                throw new IllegalArgumentException("로또 번호의 범위는 1~45 입니다.");
            }
        }
        return true;
    }

    public List<LottoNo> getNumbers() {
        return numbers;
    }

    public boolean contains(LottoNo number) {
        return numbers.contains(number);
    }

    public int getMatchedNo(Lotto anotherLotto) {
        int matchedNoCount = 0;
        for (int index = 0; index < numbers.size(); index++) {
            if (anotherLotto.contains(numbers.get(index))) {
                matchedNoCount++;
            }
        }
        return matchedNoCount;

    }

    //  todo 2-3. contains method
    // todo 3. 다른 티켓과의 겹치는 숫자
}
