package com.zingoworks.lotto.model.lotto.lottoPack;

import com.zingoworks.lotto.model.lotto.Lotto;

import java.util.ArrayList;
import java.util.List;

public class AutoLottoPack implements LottoPackGenerator {
    @Override
    public List<Lotto> generate(int count) {
        List<Lotto> autoLottoPack = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            autoLottoPack.add(Lotto.random());
        }
        return autoLottoPack;
    }

}
