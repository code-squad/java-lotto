package javaLotto.domain;

import javaLotto.GameResult;

import java.util.ArrayList;
import java.util.List;

public class WinningNumber {
    private static List<Integer> winningNumber;

    public WinningNumber(String winningNumber) {
        this.winningNumber = stringToList(winningNumber);
    }

    public static List<Integer> stringToList(String winningNumber) {
        String[] splitNumber = winningNumber.split(",");
        List<Integer> numbers = new ArrayList<>();
           for (String number : splitNumber) {
               numbers.add(Integer.parseInt(number));
        }
        return numbers;
    }

    public List<Integer> getWinningNumber() {
        return winningNumber;
    }

    public int match(List<Integer> lotto) {
        int matchCount = 0;
        for (int number : winningNumber) {
            if (lotto.contains(number)) {
                matchCount++;
            }
        }
        return matchCount;
    }

    public List<Integer> checkGrade(Lotto lottos) {
        List<Integer> result = new ArrayList<>();
        for (LottoTicket lotto :lottos.getLottos()) {
            result.add(match(lotto.getLottoTicket()));
        }
        return result;
    }
    public GameResult checkGrade2(Lotto lottos) {
        List<Integer> result = new ArrayList<>();
        for (LottoTicket lotto :lottos.getLottos()) {
            result.add(match(lotto.getLottoTicket()));
        }
        return new GameResult(result);
    }
}
