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

    public int getTotalWinningMoney(int totalCnt) {
        return winningMoney * totalCnt;
    }

    public static LottoRank valueOf(int countOfMatch, boolean matchBonus) {
        // TODO 일치하는 수를 로또 등수로 변경한다. enum 값 목록은 "Rank[] ranks = values();"와 같이 가져올 수 있다.
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
        int lottoRankNum = lottoRank.getCountOfMatch();
        if(lottoRankNum == countOfMatch) {
            LottoRank secondOrThirdLotto = isSecondLotto(matchBonus, lottoRankNum);
            return secondOrThirdLotto != null ? secondOrThirdLotto : lottoRank;
        }
        return null;
    }

    private static LottoRank isSecondLotto(boolean matchBonus, int lottoRankNum) {
        if(lottoRankNum == LottoRank.SECOND.getCountOfMatch()) {
             if(matchBonus) {
                 return SECOND;
             }
             return THIRD;
        }
        return null;
    }
}
