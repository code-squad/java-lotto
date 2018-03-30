package utils;

import domain.result.LottoNum;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.junit.Assert.*;

public class InputViewUtilsTest {
    @Test
    public void 숫자로_변환() {
        assertEquals(5000, InputViewUtils.convertNumber("5000"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void 숫자로_변환해야하는데_숫자아닌값_입력() {
        InputViewUtils.convertNumber("r--r");
    }

    @Test
    public void 로또_입력_파싱하기() {
        assertArrayEquals(new String[]{"8", "21", "23", "41", "42", "43"}, InputViewUtils.parseLottoNumbers("8, 21 , 23 , 41 , 42 , 43"));
    }

    @Test
    public void 로또_문자열_배열_숫자로_변환() {
        List<LottoNum> numbers = InputViewUtils.convertLottoNum(new String[]{"8", "21", "23", "41", "42", "43"});
        assertThat(numbers, hasItems(new LottoNum(8), new LottoNum(21), new LottoNum(23), new LottoNum(41), new LottoNum(42), new LottoNum(43)));
    }

    @Test(expected = IllegalArgumentException.class)
    public void 로또_문자열_배열_숫자로_변환할때_문자포함() {
        InputViewUtils.convertLottoNum(new String[]{"8, rt, 23, u, ., 43"});
    }

    @Test
    public void 수동구매개수가_유효한가() {
        int totalAmount = 14;
        int manualAmount = 13;
        InputViewUtils.verifyManualAmount(totalAmount, manualAmount);
    }

    @Test
    public void 수동구매개수가_자동개수보다_많음() {
        int totalAmount = 14;
        int manualAmount = 15;
        assertTrue(InputViewUtils.isOverTotalAmount(totalAmount, manualAmount));
    }

    @Test
    public void 수동구매개수가_0보다_작음() {
        assertTrue(InputViewUtils.isNegativeAmount(-1));
    }
}
