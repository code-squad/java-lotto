package controller;

import domain.Lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoFactory {
    private static final List<Integer> lottoNumbers;
    static {
        lottoNumbers = new ArrayList<>();
        for(int i = Lotto.MIN; i <= Lotto.MAX; i++){
            lottoNumbers.add(i);
        }
    }

    public static Lotto generateALotto(){
        Collections.shuffle(lottoNumbers);
        return new Lotto(lottoNumbers.subList(0, 6));
    }
}
