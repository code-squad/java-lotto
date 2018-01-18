package model;

import java.util.ArrayList;
import java.util.List;

public class WinningLotto {

    private List<Integer> numbers;

    public WinningLotto(List<Integer> numbers) {
        this.numbers = new ArrayList<>(numbers);
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }

    public int compare(UserLotto target) {
        int result = 0;
        for (Integer num : this.numbers) {
            if (target.getNumbers().contains(num)) result++;
        }
        return result;
    }
}
