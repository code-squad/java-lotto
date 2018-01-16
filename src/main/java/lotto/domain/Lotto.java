package lotto.domain;

import lotto.util.LottoUtil;
import lotto.util.LottoRecorder;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;


public class Lotto {

    private final static int LOTTO_SELECT_COUNT = 6;

    private List<LottoNumber> lotto;
    private Predicate<LottoNumber> contain = number -> contains(number);

    public Lotto() {
        lotto = new ArrayList<>();
        while (!isFull()) {
            lotto.add(noneExistsNumber());
        }
        Collections.sort(lotto,LottoNumber::compareTo);
    }

    public Lotto(String numbers) {
        if(!LottoUtil.canParsing(numbers)) new IllegalArgumentException();
        makeLotto(LottoUtil.toLottoNumberList(numbers));
    }

    public Lotto(List<LottoNumber> numbers) {
        Objects.requireNonNull(numbers);
        makeLotto(numbers);
    }

    private void makeLotto(List<LottoNumber> numbers) {
        lotto = numberingJob(numbers);
        if (!isFull()) throw new IllegalArgumentException();
    }

    private List<LottoNumber> numberingJob(List<LottoNumber> numbers) {
        return removeSameNumber(numbers).stream()
                .sorted(LottoNumber::compareTo)
                .collect(Collectors.toList());
    }

    private Set<LottoNumber> removeSameNumber(List<LottoNumber> numbers) {
        return numbers.stream().collect(Collectors.toSet());
    }

    private LottoNumber noneExistsNumber() {
        LottoNumber lottoNumber = new LottoNumber();
        return contains(lottoNumber) ? noneExistsNumber() : lottoNumber;
    }

    public boolean contains(LottoNumber number) {
        return lotto.stream().anyMatch(no -> number.equals(no));
    }

    private boolean isFull() {
        return LOTTO_SELECT_COUNT == lotto.size();
    }

    public int containCount(Lotto lotto) {
        Objects.requireNonNull(lotto);
        return (int) lotto.lotto.stream().filter(contain).count();
    }

    public LottoRecorder match(List<Lotto> lottoList) {
        return new LottoRecorder(this, lottoList);
    }

    @Override
    public String toString() {
        return  "" + lotto;
    }
}