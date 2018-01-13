package domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static domain.Lotto.getCountOfBuy;

public class LottoSeller {

    private RandomLottoNumbersGenerator generator = new RandomLottoNumbersGenerator();

    public List<Lotto> buyRandomNumberLottos(int money) {
        checkArgument(money);
        return IntStream.range(0, getCountOfBuy(money))
                        .mapToObj(i -> new Lotto(generator.createRandomLottoNumbers()))
                        .collect(Collectors.toList());
    }

    private void checkArgument(int money) {
        if (getCountOfBuy(money) <= 0) {
            throw new IllegalArgumentException();
        }
    }
}
