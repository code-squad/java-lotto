package domain;

import java.util.ArrayList;
import java.util.List;

public class LottosFactory {
    public static List<Lotto> makeLottos(int size) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            lottos.add(new Lotto(LottoFactory.makeLottoNumber()));
        }
        return lottos;
    }
}