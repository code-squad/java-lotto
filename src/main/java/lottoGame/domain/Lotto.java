package lottoGame.domain;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private List<Integer> numbers = new ArrayList<>();
    private int matchNum = 0;

    public Lotto(List<Integer> nums) {
        this.numbers = nums;
    }

    public void matchPoint(List<Integer> lasWeek) {
        for (Integer number : numbers) {
            if(lasWeek.contains(number)) {
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
}
