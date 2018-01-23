package lottoGame.domain;

import lottoGame.enums.Rank;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    List<Integer> numbers = new ArrayList<>();
    private boolean bonusMatch = false;
    private int matchNum = 0;

    public Lotto(List<Integer> nums) {
        if (nums.size() != 6) {
            throw new IllegalArgumentException();
        }
        this.numbers = nums;
    }

    public void matchPoint(WinningLotto winningLotto) {
        for (Integer number : numbers) {
            if(winningLotto.numbers.contains(number)) {
                this.matchNum++;
            }
            if(numbers.contains(winningLotto.bonusNum)) {
                bonusMatch =true;
            }
        }
    }

    public Rank lottoRank() {
        if(this.matchNum == 3) {
            return Rank.FIFTH;
        }
        if(this.matchNum == 4) {
            return Rank.FOURTH;
        }
        if(this.matchNum == 5 && this.bonusMatch) {
            return Rank.SECOND;
        }
        if(this.matchNum == 5) {
            return Rank.THIRD;
        }
        if(this.matchNum == 6) {
            return Rank.FIRST;
        }
        return Rank.MISS;
    }

    @Override
    public String toString() {
        String lotto = String.join(",", String.valueOf(numbers));
        return lotto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Lotto)) return false;

        Lotto lotto = (Lotto) o;

        if (matchNum != lotto.matchNum) return false;
        return numbers != null ? numbers.equals(lotto.numbers) : lotto.numbers == null;
    }

    @Override
    public int hashCode() {
        int result = numbers != null ? numbers.hashCode() : 0;
        result = 31 * result + matchNum;
        return result;
    }
}
