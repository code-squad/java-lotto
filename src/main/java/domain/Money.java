package domain;

import dto.WinResultDto;
import vo.Rank;

import java.util.Map;

public class Money {

    public static final int LOTTO_PRICE = 1000;

    private int purchaseAmt;

    public Money(int cash) {
        this.purchaseAmt = cash;
    }

    public static Money initString(String inputMoney){
        int purchaseAmt = Integer.parseInt(inputMoney);
        return new Money(purchaseAmt);
    }

    public int getLottoAmt() {
        return this.purchaseAmt / LOTTO_PRICE;
    }

    public long getYield(WinResultDto winResultDto) {
        return (getRevenue(winResultDto.getWinResultDto()) / this.purchaseAmt) * 100;
    }

    long getRevenue(Map<Rank, Integer> winResultDto) {
        long sum = 0;
        for (Rank rank : winResultDto.keySet()) {
            sum += (long) rank.getReward() * (long) winResultDto.get(rank);
        }

        return sum;
    }

}
