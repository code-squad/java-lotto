package domain;

public class BuyInfo {
    private Lottos manualLottos;
    private int invenstMoney;

    public BuyInfo(int invenstMoney, Lottos manualLottos) {
        this.manualLottos = manualLottos;
        this.invenstMoney = invenstMoney;
    }
}
