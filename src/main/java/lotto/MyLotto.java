package lotto;

import java.util.ArrayList;
import java.util.List;

public class MyLotto {
    private List<LottoNumbers> lottos;

    public MyLotto() {
        lottos = new ArrayList<LottoNumbers>();
    }

    public List<LottoNumbers> purchaseLottos(long money) {
        int countOfLotto = (int) money / LottoMachine.LOTTO_PRICE;
        System.out.println(countOfLotto);
        for (int index = 0; index < countOfLotto; index++) {
            lottos.add(LottoMachine.getLottoNumber());
        }
        return lottos;
    }

    public List<LottoNumbers> getLottos() {
        return lottos;
    }
}
