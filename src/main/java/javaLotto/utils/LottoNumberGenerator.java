package javaLotto.utils;

import javaLotto.domain.LottoTicket;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoNumberGenerator {
    public static LottoTicket makeLottoNumber() {
        List<Integer> numbers = new ArrayList<>();
        Collections.shuffle(setLottoNumber(numbers));
        return sortLottoNumber(selectNumbers(numbers));
    }

    private static LottoTicket selectNumbers(List<Integer> numbers) {
       return new LottoTicket(numbers.subList(0,6));
    }

    private static List<Integer> setLottoNumber(List<Integer> numbers) {
        for (int i = 1; i < 45 ; i++) {
            numbers.add(i);
        }
        return numbers;
    }

    private static LottoTicket sortLottoNumber(LottoTicket list) {
        Collections.sort(list.getLottoTicket());
        return  list;
    }
}
