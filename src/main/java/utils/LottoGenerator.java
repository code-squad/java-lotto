package utils;

import domain.Lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static utils.LottoGameValues.LOTTO_NUM_END;
import static utils.LottoGameValues.LOTTO_NUM_START;
import static utils.LottoGameValues.LOTTO_SIZE;

public class LottoGenerator {
    private static List<Integer> lottoNums = new ArrayList<>();
    
    static {
        for (int i = LOTTO_NUM_START; i <= LOTTO_NUM_END; i++) {
            lottoNums.add(i);
        }
    }

    public static Lotto generate() {
        Collections.shuffle(lottoNums);
        List<Integer> tempLottoNums = lottoNums.subList(0, LOTTO_SIZE);
        Collections.sort(tempLottoNums);
        return new Lotto(new ArrayList<>(tempLottoNums));
    }
}
