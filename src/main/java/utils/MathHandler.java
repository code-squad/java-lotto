package utils;

import static utils.LottoGameValue.LOTTO_PRICE;

public class MathHandler {
    private MathHandler() {
    }

    public static int getLottoTicketNum(int inputPurchaseAmount) {
        return inputPurchaseAmount / LOTTO_PRICE;
    }

    public static int getProfit(int profitSum, int purchaseAmount) {
        return profitSum / purchaseAmount * 100;
    }
}
