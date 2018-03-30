package utils;

import domain.Lotto;
import domain.result.LottoNum;
import view.InputView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class LottoMachine {
    private static List<LottoNum> numbers = IntStream.rangeClosed(LottoNum.MIN, LottoNum.MAX).boxed().map(LottoNum::new).collect(toList());

    public static List<Lotto> autoBuy(int totalAmount, int manualAmount) {
        int autoBuyAmount = totalAmount - manualAmount;
        if (isNegativeAmount(autoBuyAmount)) {
            throw new IllegalArgumentException("마이너스 수량은 구매할 수 없습니다.");
        }
        return buildAutoLottoBundle(autoBuyAmount);
    }

    private static boolean isNegativeAmount(int amount) {
        return amount < 0;
    }

    private static List<Lotto> buildAutoLottoBundle(int amount) {
        if (isZeroAmount(amount)) {
            return null;
        }
        List<Lotto> lottoBundle = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            lottoBundle.add(new Lotto(pickLottoNumbers()));
        }
        return lottoBundle;
    }

    private static boolean isZeroAmount(int amount) {
        return amount == 0;
    }

    private static List<LottoNum> pickLottoNumbers() {
        Collections.shuffle(numbers);
        return numbers.stream().limit(Lotto.LOTTO_NUM).collect(toList());
    }


    public static Lotto manualBuy() throws IllegalArgumentException {
        return new Lotto(InputView.getLottoNumbers());
    }

    public static List<Lotto> manualBuy(int amount) throws IllegalArgumentException {
        if (isNegativeAmount(amount)) {
            throw new IllegalArgumentException("마이너스 수량은 구매할 수 없습니다.");
        }
        return buildManualLottoBundle(amount);
    }

    private static List<Lotto> buildManualLottoBundle(int amount) {
        if (isZeroAmount(amount)) {
            return null;
        }
        List<Lotto> lottoBundle = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            lottoBundle.add(manualBuy());
        }
        return lottoBundle;
    }
}
