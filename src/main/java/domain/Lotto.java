package domain;

import dto.LottoDto;

import java.util.Set;

public class Lotto {
    static final int MAX = 45;
    static final int MIN = 1;
    static final int LOTTO_NUMBERS_SIZE = 6;

    private Set<Integer> numbers;

    Lotto(Set<Integer> numbers) {
        this.numbers = numbers;
        this.isValid();
    }

    private void isValid(){
        this.isValidSize();
        for (Integer number : this.numbers) {
            this.isValidBoundary(number);
        }
    }

    private void isValidSize(){
        if(this.numbers.size() != LOTTO_NUMBERS_SIZE) throw new IllegalArgumentException();
    }

    protected void isValidBoundary(int number){
        if(number > MAX || number < MIN) throw new IllegalArgumentException();
    }

    int calculateHitCount(Lotto other){
        int hitCount = 0;
        for (Integer number : numbers) {
            hitCount += other.isHit(number) ? 1 : 0;
        }
        return hitCount;
    }

    protected boolean isHit(int number){
        return this.numbers.contains(number);
    }

    public LottoDto toDto(){
        return new LottoDto(this.numbers);
    }
}
