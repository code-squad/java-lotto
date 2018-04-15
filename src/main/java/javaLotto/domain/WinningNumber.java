package javaLotto.domain;

import java.util.*;

import static javaLotto.domain.Rank.valueOf;

public class WinningNumber {
    //private static List<Integer> winningNumber;
    private static Set<LottoNo> winningNumber;
    private static int bonusBall;

    public WinningNumber(String winningNumber, String bonusBall) {
        this.winningNumber = stringToList(winningNumber);
        this.bonusBall = Integer.parseInt(bonusBall);
    }

    public static Set<LottoNo> stringToList(String winningNumber) {
        String[] splitNumber = winningNumber.split(",");
        Set<LottoNo> numbers = new HashSet<>();
        for (String number : splitNumber) {
            numbers.add(new LottoNo(Integer.parseInt(number)));
        }
        return numbers;
    }

    public Set<LottoNo> getWinningNumber() {
        return winningNumber;
    }

    public Result match(LottoTicket lotto) {
        int matchCount = LottoTicket.matchCount(winningNumber,lotto);
        boolean bonus = LottoTicket.matchBonus(bonusBall,lotto);
        return new Result(valueOf(matchCount, bonus));
    }

    public GameResult checkGrade(Lotto lottos) {
        List<Result> result = new ArrayList<>();
        for (LottoTicket lotto : lottos.getLottos()) {
            result.add(match(lotto));
        }
        return new GameResult(result);
    }

}
