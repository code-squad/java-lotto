package lotto;

import java.util.ArrayList;
import java.util.List;

public class WebBuy {
    private List<Lotto> lottos = new ArrayList<>();

    public List<Lotto> webManualBuy(List<String> manualNumber) {
        for (String s: manualNumber) {
            lottos.add(new Lotto(s));
        }
        return lottos;
    }

    public List<Lotto> webAutoBuy(int autoBuy) {
        for(int i = 0; i < autoBuy; i++)
            lottos.add(new Lotto());
        return lottos;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
