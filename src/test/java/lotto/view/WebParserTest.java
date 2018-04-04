package lotto.view;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static lotto.view.WebParser.parseToLottoInts;
import static org.junit.Assert.*;

public class WebParserTest {

    @Test
    public void parseToLottoInts_More_Than_One_Ticket() {
        String input = "1,2,3,4,5,6\n1,2,3,4,5,6";
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<List<Integer>> lottoInts = parseToLottoInts(input);
        List<List<Integer>> expected = Arrays.asList(numbers, numbers);
        assertArrayEquals(expected.toArray(), lottoInts.toArray());
    }
}