package utils;

import domain.Lotto;
import domain.LottoNum;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


import static domain.Lotto.LOTTO_SIZE;
import static domain.LottoNum.LOTTO_NUM_END;
import static domain.LottoNum.LOTTO_NUM_START;

public class LottoGenerator {
    private static List<LottoNum> lottoNums = new ArrayList<>();
    
    static {
        for (int i = LOTTO_NUM_START; i <= LOTTO_NUM_END; i++) {
            lottoNums.add(new LottoNum(i));
        }
    }

    public static Lotto generate() {
        Collections.shuffle(lottoNums);
        List<LottoNum> tempLottoNums = lottoNums.subList(0, LOTTO_SIZE);
//        Collections.sort(tempLottoNums);
        return new Lotto(new ArrayList<>(tempLottoNums));
    }
}
