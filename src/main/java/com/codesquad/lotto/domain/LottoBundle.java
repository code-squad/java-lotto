package com.codesquad.lotto.domain;

import java.util.List;

public class LottoBundle {
    private final List<LottoNumber> lotteries;

    public LottoBundle(final List<LottoNumber> lotteries) {
        this.lotteries = lotteries;
    }


}
