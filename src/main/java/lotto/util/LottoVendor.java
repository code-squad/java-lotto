package lotto.util;

import lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoVendor {

    private final static int LOTTO_PRICE = 1000;
    private static LottoVendor instance;

    private LottoVendor() {
    }

    public static LottoVendor getInstance() {
        if ( instance == null ) {
            instance = new LottoVendor();
        }
        return instance;
    }

    public int parseMoney(String money) {
        if (!LottoUtil.isNumeric(money)) new IllegalArgumentException();
        return Integer.parseInt(money);
    }

    public int unitPerLotto(Integer money) {
        if (money < LOTTO_PRICE) new IllegalArgumentException();
        return money/LOTTO_PRICE;
    }

    public List<Lotto> buy(String money) {
        return order(unitPerLotto(parseMoney(money)));
    }

    private List<Lotto> order(Integer count) {
        ArrayList<Lotto> lottery = new ArrayList<>();
        for (Integer i = 0; i < count; i++) {
            lottery.add(new Lotto());
        }
        return lottery;
    }
}