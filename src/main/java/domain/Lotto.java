package domain;

import dto.LottoDto;

import java.util.List;

public class Lotto {
    static final int MAX = 45;
    static final int MIN = 1;
    static final int LOTTO_NUMBERS_SIZE = 6;

    private List<Integer> numbers;

    Lotto(List<Integer> numbers) {
        this.numbers = numbers;
        this.isValid();
    }

    private void isValid(){
        if(!this.isValidBoundary() || !isValidSize()) throw new IllegalArgumentException();
    }

    private boolean isValidSize(){
        return this.numbers.size() == LOTTO_NUMBERS_SIZE;
    }

    private boolean isValidBoundary(){
        for (Integer number : this.numbers) {
            if(number > MAX || number < MIN) return false;
        }
        return true;
    }

    int calculateHitCount(Lotto other){
        int hitCount = 0;
        for (Integer number : numbers) {
            hitCount += other.isHit(number) ? 1 : 0;
        }
        return hitCount;
    }

    private boolean isHit(Integer number){
        return this.numbers.contains(number);
    }

    LottoDto toDto(){
        return new LottoDto(this.numbers);
    }
}
