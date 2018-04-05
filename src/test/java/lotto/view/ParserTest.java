package lotto.view;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static lotto.view.Parser.parseToLottoFormat;
import static org.junit.Assert.*;

public class ParserTest {
    private List<Integer> numbers;

    @Before
    public void setUp() {
        numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
    }

    @Test
    public void parseToLottoInts_More_Than_One_Ticket() {
        String input = "1,2,3,4,5,6\n1,2,3,4,5,6";
        List<List<Integer>> lottoInts = parseToLottoFormat(input);
        List<List<Integer>> expected = Arrays.asList(numbers, numbers);
        assertArrayEquals(expected.toArray(), lottoInts.toArray());
    }

    @Test
    public void parseToLottoInts_One_Ticket() {
        String input = "1,2,3,4,5,6";
        List<List<Integer>> lottoInts = parseToLottoFormat(input);
        List<List<Integer>> expected = Arrays.asList(numbers);
        assertArrayEquals(expected.toArray(), lottoInts.toArray());
    }

    @Test
    public void parseToLottoInts_One_Ticket_Plus_Return_Character() {
        String input = "1,2,3,4,5,6\n";
        List<List<Integer>> lottoInts = parseToLottoFormat(input);
        List<List<Integer>> expected = Arrays.asList(numbers);
        assertArrayEquals(expected.toArray(), lottoInts.toArray());
    }
}