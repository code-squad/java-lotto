package domain;

import java.util.List;

public class LottoWiningNum {
    public static final int MIN_NUM = 1;
    public static final int MAX_NUM = 45;
    private List<Integer> winningNumbers;

    public LottoWiningNum(List<Integer> winningNumbers) {
        if (isIncludeOutRange(winningNumbers)) {
            throw new IllegalArgumentException("범위를 벗어난 숫자가 포함되어있습니다.");
        }
        this.winningNumbers = winningNumbers;
    }

    private static boolean isIncludeOutRange(List<Integer> numbers) {
        return numbers.stream().anyMatch(number -> number < MIN_NUM || number > MAX_NUM);
    }

    public boolean isMatchNumber(int number) {
        return winningNumbers.contains(number);
    }
}
