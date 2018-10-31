package com.zingoworks.lotto.model.lotto.lottoPack;

import com.zingoworks.lotto.model.lotto.Lotto;

import java.util.List;

public interface LottoPackGenerator {
    List<Lotto> generate(int count);
}