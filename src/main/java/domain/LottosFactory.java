package domain;

import java.util.ArrayList;
import java.util.List;

public class LottosFactory {
    public static Lottos makeLottos(int size) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            lottos.add(LottoFactory.makeRandLotto());
        }
        return new Lottos(lottos);
    }
}