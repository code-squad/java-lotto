package lotto.domain;

import java.util.Arrays;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Stream;


public class Lotto {

    private final static int LOTTO_SELECT_COUNT = 6;

    private LottoNumber[] lotto;
    private Predicate<LottoNumber> contain = number -> contains(number);

    public Lotto() {
        lotto = new LottoNumber[LOTTO_SELECT_COUNT];
        while (hasNull()) {
            fill(noneExistsNumber());
        }
    }

    public Lotto(LottoNumber[] numbers) {
        lotto = numbers;
        customNumberValidationCheck();
    }

    private void customNumberValidationCheck() {
        if (isBlank()) throw new IllegalArgumentException();
        if (hasNull()) throw new IllegalArgumentException();
        if (!equalSelectCount()) throw new IllegalArgumentException();
        if (sameNumberInLotto(lotto.length-1)) throw new IllegalArgumentException();
    }

    private boolean sameNumberInLotto(int count) {
        if (count == 1) {
            return lotto[count].equals(lotto[--count]);
        }
        return lotto[count].equals(lotto[--count]) ? true : sameNumberInLotto(count);
    }

    private boolean hasNull() {
        return Stream.of(lotto).anyMatch(number -> number == null);
    }

    private void fill(LottoNumber number) {
        lotto[indexOfFirstEmpty()] = number;
    }

    private int indexOfFirstEmpty() {
        for (int i = 0; i < lotto.length; i++) {
            if (lotto[i]==null) {
                return i;
            }
        }
        throw new IllegalStateException();
    }

    private LottoNumber noneExistsNumber() {
        LottoNumber lottoNumber = new LottoNumber();
        return contains(lottoNumber) ? noneExistsNumber() : lottoNumber;
    }

    public boolean contains(LottoNumber number) {
        return Stream.of(lotto).anyMatch(no -> number.equals(no));
    }

    private boolean isBlank() {
        return lotto == null || lotto.length == 0;
    }

    private boolean equalSelectCount() {
        return LOTTO_SELECT_COUNT == lotto.length;
    }

    public int containCount(Lotto lotto) {
        Objects.requireNonNull(lotto);
        return (int) Stream.of(lotto.lotto).filter(contain).count();
    }

    @Override
    public String toString() {
        return Arrays.toString(lotto);
    }
}