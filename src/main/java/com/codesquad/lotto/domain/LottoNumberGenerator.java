package com.codesquad.lotto.domain;

import com.codesquad.lotto.vo.LottoNumber;

import java.util.List;

public interface LottoNumberGenerator {
    List<LottoNumber> generate();
}
