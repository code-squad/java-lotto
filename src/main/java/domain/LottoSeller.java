package domain;

import java.util.ArrayList;
import java.util.List;

public class LottoSeller {
    private static final int LOTTO_PRICE = 1000;

    public static List<Lotto> sellLotto(int totalPrice, LottoNumberCreationStrategy lottoNumberCreationStrategy) {
        int quantity = totalPrice / LOTTO_PRICE;
        List<Lotto> lottos = new ArrayList<>(quantity);

        for(int i = 0 ; i < quantity ; ++i)
            lottos.add(new Lotto(lottoNumberCreationStrategy));

        return lottos;
    }
}
