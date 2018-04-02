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

    List<LottoNum> getNumbers() {
        return numbers;
    }

    // TODO 라인에 보너스 넘버 포함 여부 있어야 하나?
    public boolean containsBonusNum(int bonusNum) {
        return numbers.contains(LottoNum.of(bonusNum));
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
