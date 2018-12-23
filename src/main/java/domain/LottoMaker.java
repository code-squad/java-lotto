package domain;

import utils.RandomGenerator;

import java.util.ArrayList;
import java.util.List;

public class LottoMaker {
    public static List<Lotto> generateLotto(int amount) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            lottos.add(Lotto.ofList(RandomGenerator.generateRandomNumber()));
        }

        return lottos;
    }


}
