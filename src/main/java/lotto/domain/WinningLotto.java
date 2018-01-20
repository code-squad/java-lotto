package lotto.domain;

import java.util.List;

public class WinningLotto {
    private List<Integer> numbers;
    private int bonus;

    public WinningLotto(List<Integer> numbers, int bonus) {
        this.numbers = numbers;
        this.bonus = bonus;
    }

    public int match(Lotto lotto){
        int matchCount = 0;
        for(int number : numbers){
            if(lotto.contains(number)){
                matchCount++;
            }
        }

        return matchCount;
    }

    public boolean isBonus(Lotto lotto){
        return lotto.contains(bonus);
    }

}
