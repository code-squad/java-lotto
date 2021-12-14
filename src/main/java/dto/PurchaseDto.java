package dto;

import domain.Money;

public class PurchaseDto {
    private int autoLottoSize;
    private int manualLottoSize;

    public PurchaseDto(Money payment, int numOfManualLotto) {
        this.autoLottoSize = payment.getLottoAmount() - numOfManualLotto;
        this.manualLottoSize = numOfManualLotto;
    }

    public int getAutoLottoSize() {
        return autoLottoSize;
    }

    public int getManualLottoSize() {
        return manualLottoSize;
    }
}
