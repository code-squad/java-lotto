package domain;

import static domain.LottoSeller.LOTTO_PRICE;

public class BuyInfo {
    private Lottos manualLottos;
    private int investMoney;

    public BuyInfo(int investMoney, Lottos manualLottos) {
        checkInputValid(investMoney, manualLottos);

        this.manualLottos = manualLottos;
        this.investMoney = investMoney;
    }

    private void checkInputValid(int investMoney, Lottos manualLottos) {
        if(investMoney < 0 || investMoney < getSpendMoneyToBuyManualLotto(manualLottos))
            throw new IllegalArgumentException("Invalid inputs for BuyInfo");
    }

    public int getBuyableNumberOfAutoLottos() {
        return (investMoney - getSpendMoneyToBuyManualLotto(manualLottos)) / LOTTO_PRICE;
    }

    private int getSpendMoneyToBuyManualLotto(Lottos manualLottos) {
        return manualLottos.getNumOfLottos() * LOTTO_PRICE;
    }

    public Lottos joinLottos(Lottos lottos) {
        return manualLottos.join(lottos);
    }

    public int getNumOfManualLottos() {
        return manualLottos.getNumOfLottos();
    }
}
