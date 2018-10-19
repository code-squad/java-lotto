package utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static utils.LottoGameValues.LOTTO_NUM_END;
import static utils.LottoGameValues.LOTTO_NUM_START;
import static utils.LottoGameValues.LOTTO_SIZE;

public class LottoNumGenerator {
    private static List<Integer> lottoNums = new ArrayList<>();
    
    static {
        for (int i = LOTTO_NUM_START; i <= LOTTO_NUM_END; i++) {
            lottoNums.add(i);
        }
    }

    public static List<Integer> generate() {
        Collections.shuffle(lottoNums);
        return new ArrayList<>(lottoNums.subList(0, LOTTO_SIZE));
    }
}
