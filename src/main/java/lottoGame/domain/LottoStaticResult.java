package lottoGame.domain;

import java.util.*;

public class LottoStaticResult {

    private Map<LottoRank,Integer> lottoStatisticsCntResult = new EnumMap<LottoRank, Integer>(LottoRank.class);

    {
        for(LottoRank lottoRank: LottoRank.values()) {
            lottoStatisticsCntResult.put(lottoRank,0);
        }
    }

    private LottoStaticResult() {

    }

    public static LottoStaticResult makeLottoStaticResult(List<Lotto> lottoes,WinningLotto winningLotto) {
        LottoStaticResult lottoResult = new LottoStaticResult();

        for (Lotto lotto : lottoes) {
            lottoResult.addLuckyNum(winningLotto.getSameLuckNumCnt(lotto),winningLotto.isContainBonusNum(lotto));
        }

        return lottoResult;
    }

    public int getProfitPercent(int investment) {
        if(investment == 0)
            throw new IllegalArgumentException();

        long result = getResultSum();
        result  = (result * 100) / investment;

        return (int)result;
    }

    public int getLottoStatisticsCntResult(LottoRank lottoRank) {
        return lottoStatisticsCntResult.get(lottoRank);
    }

    private void addLuckyNum(int sameLuckyNums,boolean matchBonus) {
        LottoRank lottoRank = LottoRank.valueOf(sameLuckyNums,matchBonus);
        if(lottoStatisticsCntResult.get(lottoRank) != null) {
            int cnt = lottoStatisticsCntResult.get(lottoRank);
            cnt += 1;
            lottoStatisticsCntResult.put(lottoRank,cnt);
        }
    }

    private long getResultSum() {
        long result = 0;

        Iterator<LottoRank> it = lottoStatisticsCntResult.keySet().iterator();
        while(it.hasNext()) {
            LottoRank lottoRank = it.next();
            int cnt = lottoStatisticsCntResult.get(lottoRank);
            result += (lottoRank.getWinningMoney() * cnt);
        }

        return result;
    }
}
