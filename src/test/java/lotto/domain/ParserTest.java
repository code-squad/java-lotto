package lotto.domain;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class ParserTest {

    @Test
    public void parseToInt() {
        int numberOfTickets = Parser.parseToInt("10000");
        assertEquals(10000, numberOfTickets);
    }

    @Test
    public void splitString() {
        assertArrayEquals(new String[]{"1", "2", "3", "4", "5", "6"}, Parser.splitString("1, 2, 3, 4, 5, 6"));
    }

    @Test
    public void parseToNumberArray() {
        List<Number> expected = Arrays.asList(new Number(1), new Number(2), new Number(3), new Number(4), new Number(5), new Number(6));
        List<Number> actual = Parser.parseToNumberArray(new String[]{"1", "2", "3", "4", "5", "6"});
        assertArrayEquals(expected.toArray(), actual.toArray());
    }

    @Test
    public void parseToPrintable() {
        List<Number> ticket = Arrays.asList(new Number(1), new Number(2), new Number(3), new Number(4), new Number(5), new Number(6));
        String expected = "[1, 2, 3, 4, 5, 6]";
        assertEquals(expected, Parser.parseToPrintable(ticket));
    }
}