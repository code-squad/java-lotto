package lotto.view;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class WebParserTest {

    @Test
    public void splitToLottoString() {
        List<String> lottoString = WebParser.splitToLottoString("1,2,3,4,5,6\n7,8,9,10,11,12");
        List<String> expected = Arrays.asList("1,2,3,4,5,6", "7,8,9,10,11,12");
        assertArrayEquals(expected.toArray(), lottoString.toArray());
    }

    @Test
    public void splitToNumberStrings() {
        List<String> numberString = WebParser.splitToNumberStrings("1,2,3,4,5,6");
        List<String> expected = Arrays.asList("1", "2", "3", "4", "5", "6");
        assertArrayEquals(expected.toArray(), numberString.toArray());
    }

    @Test
    public void parseToIntegers() {
        List<String> numbers = Arrays.asList("1", "2", "3", "4", "5", "6");

        List<Integer> integers = WebParser.parseToIntegers(numbers);
        List<Integer> expected = Arrays.asList(1, 2, 3, 4, 5, 6);
        assertArrayEquals(expected.toArray(), integers.toArray());
    }
}