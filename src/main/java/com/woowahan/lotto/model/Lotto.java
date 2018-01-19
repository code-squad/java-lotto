package com.woowahan.lotto.model;

import java.util.*;
import java.util.stream.Collectors;

public class Lotto {
    private static final Set<LottoNo> BASE_NUMBERS = setBaseNumbers();
    private Set<LottoNo> lotto;

    public Lotto() {
        this.lotto = create();
    }
    
    public Lotto(Set<LottoNo> lotto) {
        checkLottoSize(lotto);

        this.lotto = lotto;
    }

    public Lotto(String lotto) {
        Set<LottoNo> convertLotto = new TreeSet<>();

        String[] inputNumbers = lotto.split(",");
        for (String inputNumber : inputNumbers) {
            convertLotto.add(new LottoNo(Integer.parseInt(inputNumber.trim())));
        }

        checkLottoSize(convertLotto);
        this.lotto = convertLotto;
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
