package lotto.vo;

import org.junit.Test;

public class BonusNumberTest {
    @Test(expected = IllegalArgumentException.class)
    public void 보너스_번호는_1부터45까지의_숫자() {
        BonusNumber.of(88);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 보너스_번호는_1부터45까지의_숫자2() {
        BonusNumber.of(0);
    }
}
