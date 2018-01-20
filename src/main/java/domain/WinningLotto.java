package domain;

import java.util.List;

public class WinningLotto extends Lotto {
    private int bonusBall;

    public WinningLotto(List<Integer> numbers, int bonusBall) {
        super(numbers);
        this.bonusBall = bonusBall;
    }

    public Rank checkTheWinningNumbers(Lotto lotto) throws IllegalArgumentException {
        List<Integer> checkNumbers = lotto.numbers;
        int count = checkNumbers.stream()
                .filter(number -> numbers.contains(number))
                .reduce(0, (a, b) -> a + 1);

        return Rank.valueOf(count, checkBonusBall(checkNumbers));
    }

    private boolean checkBonusBall(List<Integer> numbers) {
        return numbers.contains(bonusBall);
    }
}
