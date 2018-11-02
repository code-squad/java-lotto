package domain;

import utils.LottoGenerator;

import java.util.ArrayList;
import java.util.List;

public class AutoLottoMachine implements LottoMachine {

    public static List<Lotto> generateLottos(Money money) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < money.countOfLottos(); i++) {
            lottos.add(LottoGenerator.generate());
        }
        return lottos;
    }

    @Override
    public List<Lotto> generate(Money money) {
        return generateLottos(money);
    }
}
