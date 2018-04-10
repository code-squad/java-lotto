package lotto;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {
    public static void printCountOfLotto(int money) {
        System.out.println((money / LottoMachine.LOTTO_PRICE) + "개를 구매했습니다.");
    }

    public static void printPurchasedLotto(List<Integer> purchasedLotto) {
        StringBuilder sb = new StringBuilder();
        System.out.println(sb.append("[")
                .append(purchasedLotto.stream().map(Object::toString).collect(Collectors.joining(", ")))
                .append("]").toString());
    }
}
