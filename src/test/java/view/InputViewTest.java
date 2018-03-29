package view;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.junit.Assert.*;

public class InputViewTest {

    @Test
    public void 숫자로_변환() {
        assertEquals(5000, InputView.convertNumber("5000"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void 숫자로_변환해야하는데_숫자아닌값_입력() {
        InputView.convertNumber("r--r");
    }

    @Test
    public void 로또_입력_파싱하기() {
        assertArrayEquals(new String[]{"8", "21", "23", "41", "42", "43"}, InputView.parseLottoNumbers("8, 21, 23, 41, 42, 43"));
    }

    @Test
    public void 로또_문자열_배열_숫자로_변환() {
        List<Integer> numbers = InputView.convertNumber(new String[]{"8", "21", "23", "41", "42", "43"});
        assertThat(numbers, hasItems(8, 21, 23, 41, 42, 43));
    }

    @Test(expected = IllegalArgumentException.class)
    public void 로또_문자열_배열_숫자로_변환할때_문자포함() {
        InputView.convertNumber(new String[]{"8, rt, 23, u, ., 43"});
    }

    @Test
    public void 수동구매개수가_유효한가() {
        int totalAmount = 14;
        int manualAmount = 13;
        InputView.verifyManualAmount(totalAmount, manualAmount);
    }

    @Test
    public void 수동구매개수가_자동개수보다_많음() {
        int totalAmount = 14;
        int manualAmount = 15;
        assertTrue(InputView.isOverTotalAmount(totalAmount, manualAmount));
    }

    @Test
    public void 수동구매개수가_0보다_작음() {
        assertTrue(InputView.isNegativeAmount(-1));
    }
}