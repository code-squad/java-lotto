package domain;

import java.util.List;

public class Lotto {
    private static final int LOTTO_MAX_SIZE = 6;
    private List<LottoNo> numbers;

    public Lotto(List<LottoNo> numbers) {
        if (!isValid(numbers)) {
            throw new IllegalArgumentException("로또 번호 6개를 입력해 주세요.");
        }
        this.numbers = numbers;
    }

    public boolean isValid(List<LottoNo> numbers) {
        if (numbers.size() != LOTTO_MAX_SIZE) {
            throw new IllegalArgumentException("로또 번호 6개를 입력해 주세요.");
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
        for (LottoNo number : numbers) {
            if (anotherLotto.contains(number)) {
                matchedNoCount++;
            }
        }
        return matchedNoCount;
    }
}
