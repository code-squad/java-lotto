package utils;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class LottoNumGeneratorTest {

    @Test
    public void generate() {
        List<Integer> lottoNums;
        for (int i = 0; i < 14; i++) {
            lottoNums = LottoNumGenerator.generate();
            System.out.println(lottoNums);
        }

    }
}