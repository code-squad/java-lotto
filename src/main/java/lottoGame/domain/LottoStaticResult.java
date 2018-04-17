package lottoGame.domain;

import java.util.*;

public class LottoStaticResult {

    private Map<LottoRank,Integer> lottoStatisticsCountResult = new EnumMap<LottoRank, Integer>(LottoRank.class);

    {
        for(LottoRank lottoRank: LottoRank.values()) {
            lottoStatisticsCountResult.put(lottoRank,0);
        }
    }

    private LottoStaticResult() {

    }

    public static LottoStaticResult makeLottoStaticResult(List<Lotto> lottoes,WinningLotto winningLotto) {
        LottoStaticResult lottoResult = new LottoStaticResult();

        for (Lotto lotto : lottoes) {
            lottoResult.addLuckyNum(winningLotto.getSameLuckNumCount(lotto),winningLotto.isContainBonusNum(lotto));
        }

        return lottoResult;
    }

    public int getProfitPercent(int investment) {
        if(investment <= 0)
            throw new IllegalArgumentException("투자금액은 0보단 커야합니다.");

        long result = getResultSum();
        result  = (result * 100) / investment;

        return (int)result;
    }

    public int getLottoStatisticsCountResult(LottoRank lottoRank) {
        return lottoStatisticsCountResult.get(lottoRank);
    }

    private void addLuckyNum(int sameLuckyNums,boolean matchBonus) {
        LottoRank lottoRank = LottoRank.valueOf(sameLuckyNums,matchBonus);
        if(lottoStatisticsCountResult.get(lottoRank) != null) {
            int Count = lottoStatisticsCountResult.get(lottoRank);
            Count += 1;
            lottoStatisticsCountResult.put(lottoRank,Count);
        }
    }

    private long getResultSum() {
        long result = 0;

        Iterator<LottoRank> it = lottoStatisticsCountResult.keySet().iterator();
        while(it.hasNext()) {
            LottoRank lottoRank = it.next();
            int Count = lottoStatisticsCountResult.get(lottoRank);
            result += (lottoRank.getWinningMoney() * Count);
        }

        return result;
    }
}
