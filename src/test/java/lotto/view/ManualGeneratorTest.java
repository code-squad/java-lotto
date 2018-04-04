package lotto.view;

import lotto.domain.Number;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class ManualGeneratorTest {
    ManualGenerator generator;

    @Before
    public void setUp() {
        int numberOfTickets = 5;
        List<Integer> manualInts = Arrays.asList(1, 2, 3, 4, 5, 6);
        generator = new ManualGenerator(5, manualInts);
    }

    @Test
    public void generateNumbers() {
        List<Number> manualNumbers = generator.convertToNumbers();
        List<Number> expected = Arrays.asList(new Number(1), new Number(2), new Number(3), new Number(4), new Number(5), new Number(6));
        assertArrayEquals(expected.toArray(), manualNumbers.toArray());
    }


}