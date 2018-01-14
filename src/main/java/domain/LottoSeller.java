package domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static common.Constant.LOTTO_PRICE;

public class LottoSeller {

    private RandomLottoNumbersGenerator generator = new RandomLottoNumbersGenerator();

    public List<Lotto> buyRandomNumberLottos(int money) {
        checkArgument(money);
        return IntStream.range(0, getCountOfBuy(money))
                        .mapToObj(i -> generator.createRandomLottoNumbers())
                        .collect(Collectors.toList());
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
