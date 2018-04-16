package javaLotto.domain;

import javaLotto.view.InputView;

import java.util.*;

import static javaLotto.utils.LottoNumberGenerator.makeLottoNumber;

public class JavaLotto {
    private static final int LOTTO_PRICE = 1000;

    public static Lotto buyLotto(int price, List<LottoTicket> manual) throws Exception {
        List<LottoTicket> lottosNumber = new ArrayList<>();
        makeLottoManual(manual, lottosNumber);
        makeLottoAuto(lottosNumber, getEa(price, manual));
        return new Lotto(lottosNumber);
    }

    private static int getEa(int price, List<LottoTicket> manual) {
        int ea = price / LOTTO_PRICE;
        ea = ea - manual.size();
        return ea;
    }

    private static void makeLottoAuto(List<LottoTicket> lottosNumber, int ea) {
        for (int buyNumber = 0; buyNumber < ea; buyNumber++) {
            lottosNumber.add(makeLottoNumber());
        }
    }

    private static void makeLottoManual(List<LottoTicket> manual, List<LottoTicket> lottosNumber) {
        for (LottoTicket ticket : manual) {
            lottosNumber.add(ticket);
        }
    }
}
