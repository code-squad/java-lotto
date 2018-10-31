package lotto.domain;

import java.util.List;

public class Money {
    private static final int LOTTO_PRICE = 1000;
    private int myMoney;

    public Money(int myMoney) {
        this.myMoney = myMoney;
        noMoney();
    }

    public int lottoCountToBuy(){
        return myMoney / LOTTO_PRICE;
    }

    public void noMoney() {
        if (lottoCountToBuy() < 1) {
            throw new IllegalArgumentException("돈이 부족합니다.");
        }
    }

    public void isOverCount(int manualCount){
        if(manualCount > lottoCountToBuy()){
            throw new IllegalArgumentException("수동으로 구입할 개수를 정확하게 입력하세요.");
        }
    }

    public int autoLottoCount(List<String> manualLottos){
        return lottoCountToBuy() - manualLottos.size();
    }

    public long yield(LottoManager lottoManager) {  // 수익률
        long result = 0;
        for (Rank value : Rank.values()) {
            result += value.getWinningMoney() * lottoManager.getRank(value);
        }
        return result * 100L / myMoney;
    }
}
