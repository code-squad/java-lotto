package com.woowahan.lotto.model;

import java.util.*;
import java.util.stream.Collectors;

public class Lotto {
    private static final Set<LottoNo> BASE_NUMBERS = setBaseNumbers();
    private Set<LottoNo> lotto;

    public Lotto() {
        this.lotto = create();
    }

    // String으로 데이터를 받는 생성자.
    public Lotto(Set<LottoNo> lotto) {
        checkLottoSize(lotto);

        this.lotto = lotto;
    }

    private void checkLottoSize(Set<LottoNo> filteredLotto) {
        if (filteredLotto.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private static Set<LottoNo> setBaseNumbers() {
        Set<LottoNo> baseNumbers = new HashSet<>();
        for (int i = 1; i <= 45; i++) {
            baseNumbers.add(new LottoNo(i));
        }

        return baseNumbers;
    }

    public Set<LottoNo> create() {
        List<LottoNo> copyBaseList = new ArrayList<>(BASE_NUMBERS);
        Collections.shuffle(copyBaseList);

        return new TreeSet<>(copyBaseList.subList(0, 6));
    }

    public boolean contains(LottoNo luck) {
        return lotto.contains(luck);
    }

    public Set<LottoNo> getLotto() {
        return lotto;
    }

    @Override
    public String toString() {
        return lotto.toString();
    }
}
