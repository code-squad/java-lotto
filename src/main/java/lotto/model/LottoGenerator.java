package lotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoGenerator {
    public static Lottos generateByMoney(int money) {
        int buyingNo = money/UserLotto.MONEY_PER_TICKET;
        ArrayList<UserLotto> lottos = new ArrayList<>();
        for (int i = 0; i < buyingNo; i++) {
            lottos.add(generateAuto());
        }
        return new Lottos(lottos);
    }

    static UserLotto generateAuto() {
        List<Integer> seed = createSeed();
        Collections.shuffle(seed);
        return new UserLotto(seed.subList(0, 6));
    }

    private static List<Integer> createSeed() {
        return IntStream.range(1, 46).boxed().collect(Collectors.toList());
    }
}
