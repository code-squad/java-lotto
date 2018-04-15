package lottogame.util;

import lottogame.LottoNo;
import lottogame.Lotto;

public class LottoUtils {

    private static final int LOTTO_PRICE = 1000;

    public static Lotto createLotto(String[] arr) {
        Lotto lotto = new Lotto();
        for (String str : arr) {
            lotto.add(new LottoNo(Integer.parseInt(MyStringUtils.trim(str))));
        }
        return lotto;
    }

    public static int getLottoTicketNumber(int money) {
        if (money < 0) {
            throw new IllegalArgumentException("구매 금액을 올바르게 입력해주세요.");
        }
        return (money / LOTTO_PRICE);
    }
}