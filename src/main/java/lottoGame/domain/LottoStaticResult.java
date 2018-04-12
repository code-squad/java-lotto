package lottoGame.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoStaticResult {

    public static final long THREE_LUCKY_PRIZE = 5000;
    public static final long FOUR_LUCKY_PRIZE = 50000;
    public static final long FIVE_LUCKY_PRIZE = 1500000;
    public static final long SIX_LUCKY_PRIZE = 2000000000;

    public static final int THREE_LUCKY_NUM = 3;
    public static final int FOUR_LUCKY_NUM = 4;
    public static final int FIVE_LUCKY_NUM = 5;
    public static final int SIX_LUCKY_NUM = 6;

    private Map<Integer,Integer> winningLuckyNumbers = new HashMap<Integer,Integer>();

    {
        winningLuckyNumbers.put(THREE_LUCKY_NUM,0);
        winningLuckyNumbers.put(FOUR_LUCKY_NUM,0);
        winningLuckyNumbers.put(FIVE_LUCKY_NUM,0);
        winningLuckyNumbers.put(SIX_LUCKY_NUM,0);
    }

    private LottoStaticResult() {

    }

    public static LottoStaticResult makeLottoStaticResult(List<Lotto> lottoes,List<Integer> luckyNums) {
        LottoStaticResult lottoResult = new LottoStaticResult();

        for (Lotto lotto : lottoes) {
            lottoResult.addLuckyNum(lotto.getSameLuckNumCnt(luckyNums));
        }

        return lottoResult;
    }

    private void addLuckyNum(int sameLuckyNums) {
        if(winningLuckyNumbers.get(sameLuckyNums) != null) {
            int luckyNumCount = winningLuckyNumbers.get(sameLuckyNums);
            winningLuckyNumbers.put(sameLuckyNums, ++luckyNumCount);
        }
    }

    public int getProfitPercent(int investment) {
        if(investment == 0)
            throw new IllegalArgumentException();

        long result = THREE_LUCKY_PRIZE * this.winningLuckyNumbers.get(THREE_LUCKY_NUM) + FOUR_LUCKY_PRIZE * this.winningLuckyNumbers.get(FOUR_LUCKY_NUM)
                + FIVE_LUCKY_PRIZE * this.winningLuckyNumbers.get(FIVE_LUCKY_NUM) + SIX_LUCKY_PRIZE * this.winningLuckyNumbers.get(SIX_LUCKY_NUM);
        result  = (result * 100) / investment;

        return (int)result;
    }

    public int getWinningLuckyNumCnt(int winningLuckyNumber) {
        return this.winningLuckyNumbers.get(winningLuckyNumber);
    }
}
