package saru.domain;

import java.util.List;

// 리스트의 집합을 만들기 위해 따로 클래스로 뺌
public class LottoLine {
    private List<LottoNum> numbers;

    private LottoLine(List<LottoNum> numbers) {
        this.numbers = numbers;
    }

    public static LottoLine of(List<LottoNum> numbers) {
        return new LottoLine(numbers);
    }

    public List<LottoNum> getNumbers() {
        return numbers;
    }

    public String getLotto() {
        return numbers.toString();
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
