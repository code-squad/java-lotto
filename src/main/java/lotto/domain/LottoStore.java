package lotto.domain;

import java.util.*;

public class LottoStore {

    private List<Lotto> lottos = new ArrayList<>();

    public LottoStore(int money) {
        if (money % 1000 != 0 || money < 1000 || money > 1000000000) {
            throw new IllegalArgumentException();
        }
        int count = money / 1000;
        while (count > 0) {
            lottos.add(new Lotto());
            count--;
        }
    }

    public LottoStore(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<Lotto> getLottos() {
        return this.lottos;
    }

    public LottoResult match(String winNumbers) {
        return new LottoResult(winNumbers, this.lottos);
    }

}
