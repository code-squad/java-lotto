package saru.domain;

import java.util.List;

// 리스트의 집합을 만들기 위해 따로 클래스로 뺌
public class LottoNumberList {
    private List<LottoNumber> numbers;

    public LottoNumberList(List<LottoNumber> numbers) {
        this.numbers = numbers;
    }

    public List<LottoNumber> getNumbers() {
        return numbers;
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
