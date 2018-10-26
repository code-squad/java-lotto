package lotto.view;

import org.junit.Test;

public class InputViewTest {
    @Test(expected = IllegalArgumentException.class)
    public void 구입금액천원이하() {
        InputView.checkBuyPrice(999);
    }
}
