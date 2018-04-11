package lottoGame.domain;

public class LottoStaticResult {

    public static final long THREE_LUCKY_PRIZE = 5000;
    public static final long FOUR_LUCKY_PRIZE = 50000;
    public static final long FIVE_LUCKY_PRIZE = 1500000;
    public static final long SIX_LUCKY_PRIZE = 2000000000;

    private int threeLuckyNum = 0;
    private int fourLuckyNum = 0;
    private int fiveLuckyNum = 0;
    private int sixLuckyNum = 0;

    private LottoStaticResult() {

    }

    public static LottoStaticResult makeLottoStaticResult(Lotto[] lottoes, int[] luckyNums) {
        LottoStaticResult lottoResult = new LottoStaticResult();

        for (Lotto lotto : lottoes) {
            lottoResult.addLuckyNum(lotto.getSameLuckNumCnt(luckyNums));
        }

        return lottoResult;
    }

    private void addLuckyNum(int sameLuckyNums) {
        switch(sameLuckyNums) {
            case 3:
                threeLuckyNum++;
                break;
            case 4:
                fourLuckyNum++;
                break;
            case 5:
                fiveLuckyNum++;
                break;
            case 6:
                sixLuckyNum++;
                break;
        }
    }

    public int getProfitPercent(int investment) {
        if(investment == 0)
            throw new IllegalArgumentException();

        long result = THREE_LUCKY_PRIZE * threeLuckyNum + FOUR_LUCKY_PRIZE * fourLuckyNum + FIVE_LUCKY_PRIZE * fiveLuckyNum + SIX_LUCKY_PRIZE * sixLuckyNum;
        result  = (result * 100) / investment;

        return (int)result;
    }

    public int getThreeLuckyNum() {
        return threeLuckyNum;
    }

    public int getFourLuckyNum() {
        return fourLuckyNum;
    }

    public int getFiveLuckyNum() {
        return fiveLuckyNum;
    }

    public int getSixLuckyNum() {
        return sixLuckyNum;
    }
}
