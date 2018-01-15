package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoStore {

    private List<Lotto> lottos = new ArrayList<>();

    private int count;

    public LottoStore(int money) {
        if (money % 1000 != 0 || money < 1000 || money > 1000000000) {
            throw new IllegalArgumentException();
        }
        this.count = money / 1000;
        int index = count;
        while (index > 0) {
            lottos.add(new Lotto());
            index--;
        }
    }

    public LottoStore(List<Lotto> lottos) {
        this.lottos = lottos;
        this.count = lottos.size();
    }

    public List<Lotto> getLottos() {
        return this.lottos;
    }

    public int getCount() {
        return this.count;
    }
}
