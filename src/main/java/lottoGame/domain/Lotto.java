package lottoGame.domain;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private List<Integer> numbers = new ArrayList<>();
    private int matchNum = 0;

    public Lotto(List<Integer> nums) {
        if (nums.size() != 6) {
            throw new IllegalArgumentException();
        }
        this.numbers = nums;
    }

    public void matchPoint(Lotto lastWeekLotto) {
        for (Integer number : numbers) {
            if(lastWeekLotto.numbers.contains(number)) {
                this.matchNum++;
            }
        }
    }

    public int profit() {
        if(this.matchNum == 3) {
            return 5000;
        }
        if(this.matchNum == 4) {
            return 50000;
        }
        if(this.matchNum == 5) {
            return 1500000;
        }
        if(this.matchNum == 6) {
            return 2000000000;
        }
        return 0;
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
