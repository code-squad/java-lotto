package domain;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static common.Constant.LOTTO_PRICE;

public class LottoSeller {

    private RandomLottoGenerator generator = new RandomLottoGenerator();

    private static int getRemainedAmount(int money, int manualLottosSize) {
        return money - manualLottosSize * LOTTO_PRICE;
    }

    public Lottos buyRandomLottosWithManualLottos(int money, Lottos manualLottos) {
        int manualLottosSize = manualLottos != null ? manualLottos.size() : 0;

        Optional<Lottos> randomLottos = buyRandomLottos(getRemainedAmount(money, manualLottosSize));
        return new Lottos(manualLottos, randomLottos.orElse(null));
    }

    private int getCountOfBuy(int money) {
        return money / LOTTO_PRICE;
    }

    Optional<Lottos> buyRandomLottos(int money) {
        if (getCountOfBuy(money) <= 0) {
            return Optional.empty();
        }
        return Optional.of(new Lottos(IntStream.range(0, getCountOfBuy(money))
                                               .mapToObj(i -> generator.createRandomLotto())
                                               .collect(Collectors.toList())));
    }

}
