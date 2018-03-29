package utils;

import domain.Lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class LottoMachine {
    private static List<Integer> numbers = IntStream.rangeClosed(Lotto.MIN_NUM, Lotto.MAX_NUM).boxed().collect(toList());

    public static List<Lotto> autoBuy(int amount) {
        if (!canBuy(amount)) {
            throw new IllegalArgumentException("1개 이상은 사야합니다");
        }

        List<Lotto> lottoBundle = new ArrayList<>();
        for (int cnt = 0; cnt < amount; cnt++) {
            lottoBundle.add(new Lotto(pickLottoNumbers()));
        }
        return lottoBundle;
    }

    public static boolean canBuy(int amount) {
        return amount > 0;
    }

    private static List<Integer> pickLottoNumbers() {
        Collections.shuffle(numbers);
        return numbers.stream().limit(Lotto.LOTTO_NUM).collect(toList());
    }

    public static Lotto manualBuy(List<Integer> numbers) throws IllegalArgumentException {
        return new Lotto(numbers);
    }
}
