package lotto.lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Parse {

    public static List<Integer> parse(String numbers) {
        return divideNum(escapeNum(numbers));
    }

    public static String[] escapeNum(String numbers) {
        return numbers.split(",");
    }

    public static int intOf(String num) {
        return Integer.parseInt(num.trim());
    }

    public static List<Integer> divideNum(String[] numbers) {
        List<Integer> lotto = new ArrayList<>();
        LottoException.notLottoException(numbers);      //6개의 숫자가 입력되는지 확인
        for (String num : numbers) {
            int oneNumber = intOf(num);
            LottoException.overException(oneNumber);   //1부터 45까지만 입력되는지 확인
            lotto.add(oneNumber);
        }
        LottoException.sameNumberException(lotto);    //같은 번호가 입력되는지 확인
        return lotto;
    }

}
