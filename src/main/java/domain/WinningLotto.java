package domain;

import java.util.List;

public class WinningLotto extends Lotto {
    private int bonusBall;

    public WinningLotto(List<Integer> numbers, int bonusBall) {
        super(numbers);
        this.bonusBall = bonusBall;
    }

    public Rank checkTheWinningNumbers(UserLotto lotto) {
        List<Integer> checkNumbers = lotto.numbers;
        int count = 0;
        for (int i = 0; i < 6; i++) {
            if (numbers.contains(checkNumbers.get(i))) {
                count++;
            }
        }
        return Rank.valueOf(count, checkBonusBall(checkNumbers));
    }

    private boolean checkBonusBall(List<Integer> numbers) {
        return numbers.contains(bonusBall);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int number : numbers) {
            sb.append(number);
            sb.append(", ");
        }
        sb.delete(sb.length() - 2, sb.length());
        sb.append("]");
        return sb.toString();
    }
}
