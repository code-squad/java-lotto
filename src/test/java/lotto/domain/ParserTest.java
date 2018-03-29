package lotto.domain;

import org.junit.Test;

import static org.junit.Assert.*;

public class ParserTest {

    @Test
    public void parseToInt() {
        int numberOfTickets = Parser.parseToInt("10000");
        assertEquals(10000, numberOfTickets);
    }

    @Test
    public void getNumberOfTickets() {
        assertEquals(10, Parser.getNumberOfTickets(10000));
    }
}