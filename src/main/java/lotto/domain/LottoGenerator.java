package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static lotto.domain.LottoNo.LOTTO_MAX;
import static lotto.domain.LottoNo.LOTTO_MIN;

public class LottoGenerator {
    private static List<LottoNo> lottoNo = new ArrayList<>();
    static {
        for (int i = LOTTO_MIN; i <= LOTTO_MAX; i++) {
            lottoNo.add(LottoNo.of(i));
        }
    }

    public static Lotto createLotto(){
        Collections.shuffle(lottoNo);
        return Lotto.ofAuto(new ArrayList<>(lottoNo.subList(0,6)));
    }
}
