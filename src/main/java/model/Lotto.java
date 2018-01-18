package model;

import lombok.Getter;

import java.util.List;

@Getter
public class Lotto {

    private List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public Integer matchCount(Lotto winningLotto){
        Integer hit = 0;
        for (Integer one : numbers) {
            if (winningLotto.getNumbers().contains(one)) {
                hit++;
            }
        }
        return hit;
    }

    public boolean isMatchBonus(Integer bonusNum) {
        Boolean result = false;
        for (Integer number : numbers) {
            result = number.equals(bonusNum);
        }
        return result;
    }
}
