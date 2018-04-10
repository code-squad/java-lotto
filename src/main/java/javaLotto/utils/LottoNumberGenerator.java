package javaLotto.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class LottoNumberGenerator {

    private static final int lottoNumber = 6;

    public static List<Integer> makeLottoNumber() {
        List<Integer> numbers = new ArrayList<>();
        Collections.shuffle(setLottoNumber(numbers));
        return sortLottoNumber(selectNumbers(numbers));
    }

    private static List<Integer> selectNumbers(List<Integer> numbers) {
        List<Integer> lotto = new ArrayList<>();
        for(int number : numbers){
            lotto.add(number);
            if(lotto.size()== lottoNumber)break;
        }
        return lotto;
    }

    private static List<Integer> setLottoNumber(List<Integer> numbers) {
        for (int i = 1; i < 45 ; i++) {
            numbers.add(i);
        }
        return numbers;
    }

    private static List<Integer> sortLottoNumber(List<Integer> list) {
        Collections.sort(list);
        return list;
    }
}
