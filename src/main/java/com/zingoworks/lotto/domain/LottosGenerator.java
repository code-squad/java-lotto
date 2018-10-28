package com.zingoworks.lotto.domain;

import java.util.List;

public interface LottosGenerator {
    List<Lotto> generate(Money money);
}
