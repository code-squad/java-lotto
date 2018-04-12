package javaLotto.domain;

import java.util.ArrayList;
import java.util.List;

import static javaLotto.utils.LottoNumberGenerator.makeLottoNumber;

public class JavaLotto {
    private static final int LOTTO_PRICE = 1000;
    public static Lotto buyLotto(int price) throws Exception {
        int ea = price / LOTTO_PRICE;
        List<LottoTicket> lottosNumber = new ArrayList<>();
        for (int i = 0; i < ea ; i++) {
            lottosNumber.add(makeLottoNumber());
        }
        return new Lotto(lottosNumber);
    }
}
