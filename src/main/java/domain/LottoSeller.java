package domain;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static common.Constant.LOTTO_PRICE;

public class LottoSeller {

    private RandomLottoGenerator generator = new RandomLottoGenerator();

    public Optional<Lottos> buyRandomNumberLottos(int money) {
        if (getCountOfBuy(money) <= 0) {
            return Optional.empty();
        }
        return Optional.of(new Lottos(IntStream.range(0, getCountOfBuy(money))
                                               .mapToObj(i -> generator.createRandomLotto())
                                               .collect(Collectors.toList())));
    }

    private int getCountOfBuy(int money) {
        return money / LOTTO_PRICE;
    }

}
