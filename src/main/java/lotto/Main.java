package lotto;

import lotto.io.InputView;
import lotto.util.LottoVendor;

public class Main {
    public static void main(String[] args) {
        LottoVendor.getInstance().result(
                LottoVendor.getInstance().buy(InputView.inputMoney())
        );
    }
}
