package lotto.util;

import lotto.domain.Lotto;
import lotto.io.Money;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class LottoVendorTest {

    @Test(expected = IllegalArgumentException.class)
    public void 금액_입력_최소_1000이상() {
        new Money(999);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 금액_입력_최소_1000이상_문자열() {
        new Money("999");
    }

    @Test
    public void 금액을_로또의_개수로_파싱한다() {
        new Money(2000);
        new Money("1999");
        assertEquals(16, new Money("16000").exchangeToLottoCount());
    }

    @Test
    public void 로또를_구매한다() {
        assertEquals(10 ,LottoVendor.getInstance().buy(10, false).size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void 지난주_로또_당첨_번호를_null() {
        assertFalse(LottoUtil.canLotto("  \n"));
        new Lotto("   \n");
    }

    @Test(expected = IllegalArgumentException.class)
    public void 지난주_로또_당첨_번호를_입력_기호_예외처리() {
        assertFalse(LottoUtil.canLotto("r1,2,3,4,5,6d"));
        new Lotto("r1,2,3,4,5,6d");
    }

    @Test(expected = IllegalArgumentException.class)
    public void 지난주_로또_당첨_번호를_입력_개수_부족() {
        assertFalse(LottoUtil.canLotto("1,2"));
        new Lotto("1,2");
    }

    @Test(expected = IllegalArgumentException.class)
    public void 지난주_로또_같은_번호를_입력() {
        assertFalse(LottoUtil.canLotto("1,1,1,1,1,1"));
        new Lotto("1,1,1,1,1,1");
    }

    @Test(expected = IllegalArgumentException.class)
    public void 수동으로_로또만들기_숫자_범위_제한() {
        assertFalse(LottoUtil.canLotto("1,2,3,4,5,46"));
        assertFalse(LottoUtil.canLotto("1,2,3,4,5,0"));
        new Lotto("1,2,3,4,5,46");
    }

    @Test(expected = IllegalArgumentException.class)
    public void 수동으로_로또만들기_잘못된_구분자() {
        assertFalse(LottoUtil.canLotto("1,2,3,5:5,6"));
        assertFalse(LottoUtil.canLotto("1,2,3,5 5,6"));
        new Lotto("1,2,3,5:5,6");
    }

    @Test
    public void 지난주_로또_당첨_번호를_입력() {
    new Lotto("1,2,3,4,5,6");
    }
}