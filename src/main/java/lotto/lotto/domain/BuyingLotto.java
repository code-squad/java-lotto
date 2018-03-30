package lotto.lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class BuyingLotto {

    private static final int LOTTO = 1000;
    private static final int ZERO = 0;
    private List<Lotto> lottos;

    public BuyingLotto(int money) {
        moneyCheckException(money);
        this.lottos = buyLottoAutomatic(money / LOTTO);
    }

    private List<Lotto> buyLottoAutomatic(int buyingNum) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < buyingNum; i++) {
            lottos.add(Lotto.automaticLotto());
        }
        return lottos;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public void moneyCheckException(int money) {
        if (money < LOTTO)
            throw new IllegalArgumentException("돈이 부족합니다.");
        if (money % LOTTO != ZERO) {
            throw new IllegalArgumentException("1000원 단위로 입력해 주세요");
        }
    }
}
