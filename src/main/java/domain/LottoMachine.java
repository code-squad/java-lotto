package domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoMachine {
    private static LottoMachine machine = new LottoMachine();
    private static List<Integer> numbers = IntStream.rangeClosed(1, 45).boxed().collect(Collectors.toList());
    private static final int LOTTO_PRICE = 1000;

    private LottoMachine() {

    }

    public static LottoMachine of() {
        return machine;
    }

    public static boolean isNotEnoughMoney(int money) {
        int lottoQuantity = money / LOTTO_PRICE;
        return lottoQuantity < 0;
    }

    // TODO : 리턴 타입을 어떻게 할 것인가?
    public Lotto publishLotto(int money) {
        //개수만큼 발행

        return null;
    }


}
