package util;

import dto.LottoDto;
import dto.LottosDto;
import org.junit.Test;
import vo.No;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class ParserTest {

    @Test
    public void strToInt() {
        String test = "1,2,3,4,5,6";
        LottoDto nums = Parser.strToInt(test);

        System.out.println(nums);
    }

    @Test
    public void stringParser() {
        String test = "1,2,3,4,5,6\n1,2,3,4,5,6\n2,3,4,5,6,7";
        LottosDto lottoDtos = Parser.strValueToLottoDto(test);

        lottoDtos.getLottoDtos().stream().forEach(System.out::println);
    }
}