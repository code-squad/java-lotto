package com.codesquad.lotto.domain;

import com.codesquad.lotto.vo.LottoNumber;

import java.util.List;

public interface Shuffler {
    void shuffle(List<LottoNumber> numbers);
}
