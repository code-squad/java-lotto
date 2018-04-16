package javaLotto.domain;

import java.util.*;
import java.util.stream.Collectors;

import static javaLotto.domain.Rank.valueOf;

public class WinningNumber {
    private static Set<LottoNo> winningNumber;
    private static int bonusBall;

    public WinningNumber(String winningNumber, String bonusBall) {
        this.winningNumber = stringToList(winningNumber);
        this.bonusBall = Integer.parseInt(bonusBall);
    }

    public static Set<LottoNo> stringToList(String winningNumber) {
        return new HashSet<>(Arrays.asList(winningNumber.split(","))
                .stream()
                .map(no -> new LottoNo(no))
                .limit(6).collect(Collectors.toSet()));
    }

    public Set<LottoNo> getWinningNumber() {
        return winningNumber;
    }

    public Result match(LottoTicket lotto) {
        return new Result(valueOf(LottoTicket.matchCount(winningNumber,lotto), LottoTicket.matchBonus(bonusBall,lotto)));
    }

    public GameResult checkGrade(Lotto lottos) {
        List<Result> result = new ArrayList<>();
        for (LottoTicket lotto : lottos.getLottos()) {
            result.add(match(lotto));
        }
        return new GameResult(result);
    }

}
