package com.codesquad.lotto.infrastructure;

import com.codesquad.lotto.domain.Shuffler;
import com.codesquad.lotto.vo.LottoNumber;

import java.util.Collections;
import java.util.List;

public class DefaultShuffler implements Shuffler {

    @Override
    public void shuffle(final List<LottoNumber> numbers) {
        Collections.shuffle(numbers);
    }
}
