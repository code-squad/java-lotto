package domain;

import dto.LottoDto;
import vo.LottoNo;

import java.util.Objects;
import java.util.Set;

public class Lotto {
    public static final int MAX = 45;
    public static final int MIN = 1;
    public static final int LOTTO_NUMBERS_SIZE = 6;

    private Set<LottoNo> numbers;

    Lotto(Set<LottoNo> numbers) {
        this.numbers = isValidNumbersCount(numbers);
    }

    private Set<LottoNo> isValidNumbersCount(Set<LottoNo> numbers){
        if(numbers.size() != LOTTO_NUMBERS_SIZE) throw new IllegalArgumentException("Duplication.");
        return numbers;
    }

    int calculateHitCount(Lotto other){
        int hitCount = 0;
        for (LottoNo number : numbers) {
            hitCount += other.isHit(number) ? 1 : 0;
        }
        return hitCount;
    }

    protected boolean isHit(LottoNo number){
        return this.numbers.contains(number);
    }

    LottoDto toDto(){
        return new LottoDto(this.numbers);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto = (Lotto) o;
        return Objects.equals(numbers, lotto.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }
}
