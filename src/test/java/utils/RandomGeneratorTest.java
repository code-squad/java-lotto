package utils;

import org.junit.Test;
import vo.Num;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class RandomGeneratorTest {
    @Test
    public void generateRandomNumberTest() {
        for (int i = 0; i < 100; i++) {
            if (RandomGenerator.generateRandomNumber().size() != 6) throw new IllegalArgumentException();
        }
    }
}