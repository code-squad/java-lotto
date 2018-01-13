package lotto;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static lotto.Lotto.getCount;

public class LottoSeller {

    private RandomLottoNumbersGenerator generator = new RandomLottoNumbersGenerator();

    public List<Lotto> buyRandomNumberLottos(int money) {
        checkArgument(money);
        return IntStream.range(0, getCount(money))
                        .mapToObj(i -> new Lotto(generator.getRandomLottoNumbers()))
                        .collect(Collectors.toList());
    }

    private void checkArgument(int money) {
        if (getCount(money) <= 0) {
            throw new IllegalArgumentException();
        }
    }
}
