package lottoGame.domain;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

public enum LottoRank {

    MISS(0, 0),
    FIFTH(3, 5_000),
    FOURTH(4, 50_000),
    THIRD(5, 1_500_000),
    SECOND(5, 30_000_000),
    FIRST(6, 2_000_000_000);

    private int countOfMatch;
    private int winningMoney;

    private LottoRank(int countOfMatch, int winningMoney) {
        this.countOfMatch = countOfMatch;
        this.winningMoney = winningMoney;
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public int getWinningMoney() {
        return winningMoney;
    }

    public static LottoRank valueOf(int countOfMatch, boolean matchBonus) {

        LottoRank rankLotto = null;

        for(LottoRank lottoRank: values()) {
           rankLotto = judgeLottoRank(countOfMatch, matchBonus, lottoRank);
           if (rankLotto != null) {
               return rankLotto;
           }
        }
        return MISS;
    }

    private static LottoRank judgeLottoRank(int countOfMatch, boolean matchBonus, LottoRank lottoRank) {

        if(lottoRank.isMatch(countOfMatch)) {
            LottoRank secondOrThirdLotto = isSecondLotto(matchBonus, countOfMatch);
            return secondOrThirdLotto != null ? secondOrThirdLotto : lottoRank;
        }
        return null;
    }

    private static LottoRank isSecondLotto(boolean matchBonus, int countOfMatch) {
        if(SECOND.isMatch(countOfMatch)) {
             return matchBonus ? SECOND : THIRD;
        }
        return null;
    }

    private boolean isMatch(int countOfMatch) {
        return this.countOfMatch == countOfMatch;
    }
}
