package dto;

import vo.LottoNo;

import java.util.Set;

public class LottoDto {
    private Set<LottoNo> numbers;
    public LottoDto(Set<LottoNo> numbers) {
        this.numbers = numbers;
    }

    public Set<LottoNo> getNumbers() {
        return numbers;
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
