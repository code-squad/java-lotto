package dto;

import vo.LottoNumber;

import java.util.List;

public class LottoDto {
    private List<LottoNumber> numbers;

    public LottoDto(List<LottoNumber> numbers) {
        this.numbers = numbers;
    }

    public List<LottoNumber> getNumbers() {
        return numbers;
    }
}
