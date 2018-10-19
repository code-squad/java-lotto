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

    public int getLottoAmt() {
        return this.purchaseAmt / LOTTO_PRICE;
    }

    public int getYield(WinResultDto winResultDto) {
        return (getRevenue(winResultDto.getWinResultDto()) / this.purchaseAmt) * 100;
    }

    private int getRevenue(Map<Rank, Integer> winResultDto) {
        int sum = 0;
        for (Rank rank : winResultDto.keySet()) {
            sum += rank.getReward() * winResultDto.get(rank);
        }

        return sum;
    }

}
