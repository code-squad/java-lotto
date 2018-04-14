package com.codesquad.lotto.infrastructure;

import com.codesquad.lotto.domain.Shuffler;

import java.util.Collections;
import java.util.List;

public class DefaultShuffler implements Shuffler {

    @Override
    public void shuffle(final List<Integer> numbers) {
        Collections.shuffle(numbers);
    }
}
