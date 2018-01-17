package domain;


import java.util.ArrayList;
import java.util.List;

public class LottoSeller {
    private static final int LOTTO_PRICE = 1000;
    private LottoNumberCreationStrategy lottoNumCreateor;

    public LottoSeller(LottoNumberCreationStrategy lottoNumCreator) {
        this.lottoNumCreateor = lottoNumCreator;
    }

    public List<Lotto> buyLotto(int totalPrice) {
        int quantity = totalPrice / LOTTO_PRICE;
        List<Lotto> lottos = new ArrayList<>(quantity);

        for(int i = 0 ; i < quantity ; ++i)
            lottos.add(new Lotto(lottoNumCreateor.createLottoNums()));

        return lottos;
    }
}
