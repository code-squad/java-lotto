package domain;


import java.util.ArrayList;
import java.util.List;

public class LottoSeller {
    public static final int LOTTO_PRICE = 1000;
    private LottoNumberCreationStrategy lottoNumCreator;

    public LottoSeller(LottoNumberCreationStrategy lottoNumCreator) {
        this.lottoNumCreator = lottoNumCreator;
    }

    public Lottos buyLotto(BuyInfo buyInfo) {
        Lottos autoLottos = createAutoLottos(buyInfo);

        return buyInfo.joinLottos(autoLottos);
    }

    private Lottos createAutoLottos(BuyInfo buyInfo) {
        int quantity = buyInfo.getBuyableNumberOfAutoLottos();
        List<Lotto> lottos = new ArrayList<>(quantity);

        for(int i = 0 ; i < quantity ; ++i)
            lottos.add(new Lotto(lottoNumCreator.createLottoNums()));

        return new Lottos(lottos);
    }
}
