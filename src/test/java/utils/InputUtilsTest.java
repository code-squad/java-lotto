package utils;

import domain.LottoNum;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.junit.Assert.*;

public class InputUtilsTest {
    @Test
    public void 숫자로_변환() {
        assertEquals(5000, InputUtils.convertNumber("5000"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void 숫자로_변환해야하는데_숫자아닌값_입력() {
        InputUtils.convertNumber("r--r");
    }

    @Test
    public void 로또_입력_파싱하기() {
        assertArrayEquals(new String[]{"8", "21", "23", "41", "42", "43"}, InputUtils.parseLottoNumbers("8, 21 , 23 , 41 , 42 , 43"));
    }

    @Test
    public void 로또_문자열_배열_숫자로_변환() {
        List<LottoNum> numbers = InputUtils.convertLottoNum(new String[]{"8", "21", "23", "41", "42", "43"});
        assertThat(numbers, hasItems(new LottoNum(8), new LottoNum(21), new LottoNum(23), new LottoNum(41), new LottoNum(42), new LottoNum(43)));
    }

    @Test(expected = IllegalArgumentException.class)
    public void 로또_문자열_배열_숫자로_변환할때_문자포함() {
        InputUtils.convertLottoNum(new String[]{"8, rt, 23, u, ., 43"});
    }

    @Test
    public void 수동구매개수가_유효한가() {
        int totalAmount = 14;
        int manualAmount = 13;
        InputUtils.verifyManualAmount(totalAmount, manualAmount);
    }

    @Test
    public void 수동구매개수가_자동개수보다_많음() {
        int totalAmount = 14;
        int manualAmount = 15;
        assertTrue(InputUtils.isOverTotalAmount(totalAmount, manualAmount));
    }

    @Test
    public void 수동구매개수가_0보다_작음() {
        assertTrue(InputUtils.isNegativeAmount(-1));
    }

    @Test
    public void 행_기준으로_수동구매_나누기() {
        assertArrayEquals(new String[]{"1,2,3,4,5,6", "1,2,3,4,5,6", "1,2,3,4,5,6"}, InputUtils.splitLottoNumbers("1,2,3,4,5,6\n" +
                "1,2,3,4,5,6\n" +
                "1,2,3,4,5,6"));
    }

    @Test
    public void 행_기준으로_나눠진_수동구매_번호별로나누기() {
        List<String[]> numbers = InputUtils.parseLottoNumbers(new String[]{"1,2,3,4,5,6", "1,2,3,4,5,6", "1,2,3,4,5,6"});
        assertArrayEquals(numbers.get(0), new String[]{"1", "2", "3", "4", "5", "6"});
    }

    @Test
    public void 수동구매_문자열_로또번호로_변경하기() {
        List<String[]> numbers = InputUtils.parseLottoNumbers(new String[]{"1,2,3,4,5,6", "1,2,3,4,5,6", "1,2,3,4,5,6"});
        assertArrayEquals(numbers.get(0), new String[]{"1", "2", "3", "4", "5", "6"});
    }

    @Test
    public void 수동구매_로또번호들_로또로_변환하기() {
        List<String[]> numbers = InputUtils.parseLottoNumbers(new String[]{"1,2,3,4,5,6", "1,2,3,4,5,6", "1,2,3,4,5,6"});
        assertArrayEquals(numbers.get(0), new String[]{"1", "2", "3", "4", "5", "6"});
    }
}
