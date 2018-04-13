package LottoGameUtil;

import LottoGame.LottoNo;
import LottoGame.LottoNos;

public class LottoUtils {

    private static final int LOTTO_PRICE = 1000;

    public static LottoNos createLotto(String[] arr) {
        LottoNos lottoNos = new LottoNos();
        for (String str : arr) {
            lottoNos.add(new LottoNo(Integer.parseInt(MyStringUtils.trim(str))));
        }
        return lottoNos;
    }

    public static int getLottoTicketNumber(int money) {
        if(money < 0) {
            throw new IllegalArgumentException("구매 금액을 올바르게 입력해주세요.");
        }
        return (money / LOTTO_PRICE);
    }
}