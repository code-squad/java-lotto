package domain;

import dto.PurchaseDto;

public class Purchase {
    private static final String NOT_ENOUGH_MONEY_TO_PURCHASE_LOTTO_MSG = "금액이 부족하여 로또를 구매할 수 없습니다";

    private Money payment;
    private int numOfManualLotto;

    public Purchase(Money payment, int numOfManualLottoPurchase) {
        isValidPurchase(payment, numOfManualLottoPurchase);
        this.payment = payment;
        this.numOfManualLotto = numOfManualLottoPurchase;
    }

    private void isValidPurchase(Money payment, int numOfManualLottoPurchase) {
        if(payment.getLottoAmount() < numOfManualLottoPurchase) {
            throw new RuntimeException(NOT_ENOUGH_MONEY_TO_PURCHASE_LOTTO_MSG);
        }
    }

    public int getAutoSize() {
        return payment.getLottoAmount() - numOfManualLotto;
    }

    public PurchaseDto toDto() {
        return new PurchaseDto(payment, numOfManualLotto);
    }
}
