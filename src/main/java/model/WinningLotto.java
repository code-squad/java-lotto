package model;

import java.util.ArrayList;
import java.util.List;

public class WinningLotto {

    private List<Integer> numbers;
    private int bonusNumber;

    public WinningLotto(List<Integer> numbers, int bonusNumber) {
        this.numbers = new ArrayList<>(numbers);
        this.bonusNumber = bonusNumber;
    }

    public int compare(UserLotto target) {
        int result = 0;
        for (Integer num : this.numbers) {
            if (target.getNumbers().contains(num)) result++;
        }
        return result;
    }

    public boolean compareBonus(UserLotto target) {
        return target.getNumbers().contains(this.bonusNumber);
    }
}
