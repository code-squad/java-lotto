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
        int quantity = buyInfo / LOTTO_PRICE;
        List<Lotto> lottos = new ArrayList<>(quantity);

        for(int i = 0 ; i < quantity ; ++i)
            lottos.add(new Lotto(lottoNumCreator.createLottoNums()));

        return new Lottos(lottos);
    }
}
