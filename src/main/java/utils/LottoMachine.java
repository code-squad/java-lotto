package utils;

import domain.Lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class LottoMachine {
    private static LottoMachine machine = new LottoMachine();
    private static List<Integer> numbers = IntStream.rangeClosed(Lotto.MIN_NUM, Lotto.MAX_NUM).boxed().collect(toList());
    public static final int LOTTO_PRICE = 1000;

    private LottoMachine() {

    }

    public static LottoMachine of() {
        return machine;
    }

    public static int calcQuantity(int money) {
        return money / LOTTO_PRICE;
    }

    public static boolean isImPossibleBuy(int amount) {
        return amount <= 0;
    }

    public List<Lotto> publishLotto(int amount) {
        List<Lotto> lottoBundle = new ArrayList<>();
        for (int cnt = 0; cnt < amount; cnt++) {
            lottoBundle.add(new Lotto(pickLottoNumbers()));
        }
        return lottoBundle;
    }

    private List<Integer> pickLottoNumbers() {
        Collections.shuffle(numbers);
        return numbers.stream().limit(Lotto.LOTTO_NUM).collect(toList());
    }
}
