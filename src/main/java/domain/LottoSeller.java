package domain;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static common.Constant.LOTTO_PRICE;

public class LottoSeller {

    private RandomLottoGenerator generator = new RandomLottoGenerator();

    public Lottos buyRandomNumberLottos(int money) {
        checkArgument(money);
        return new Lottos(IntStream.range(0, getCountOfBuy(money))
                                   .mapToObj(i -> generator.createRandomLotto())
                                   .collect(Collectors.toList()));
    }

    private int getCountOfBuy(int money) {
        return money / LOTTO_PRICE;
    }

    private void checkArgument(int money) {
        if (getCountOfBuy(money) <= 0) {
            throw new IllegalArgumentException();
        }
    }
}
