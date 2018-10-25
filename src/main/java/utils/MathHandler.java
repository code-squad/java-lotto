package utils;

import static utils.LottoGameValues.LOTTO_PRICE;

public class MathHandler {
    private MathHandler() {
    }

    public static int getLottoTicketNum(int inputPurchaseAmount) {
        return inputPurchaseAmount / LOTTO_PRICE;
    }

    public static int getProfit(int profitSum, double purchaseAmount) {
        return (int)(profitSum / purchaseAmount * 100);
    }
}
