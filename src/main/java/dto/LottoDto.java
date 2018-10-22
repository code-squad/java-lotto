package dto;

import java.util.Set;

public class LottoDto {
    private Set<Integer> numbers;
    public LottoDto(Set<Integer> numbers) {
        this.numbers = numbers;
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
