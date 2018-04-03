package input;

import lotto.Lotto;

import java.util.ArrayList;
import java.util.List;

public class InputCommon {
    private List<Lotto> lottos = new ArrayList<>();

    public List<Lotto> makeLottos(int num) {
        for(int i = 0; i < num; i++) {
            Lotto lotto = new Lotto();
            lottos.add(lotto);
            System.out.println(lotto.getLotto());
        }
        return lottos;
    }

    public List<Lotto> addManualLottos(List<String> manual) {
        for(int i = 0; i < manual.size(); i++) {
            Lotto lotto = new Lotto(manual.get(i));
            lottos.add(lotto);
        }
        return lottos;
    }
}
