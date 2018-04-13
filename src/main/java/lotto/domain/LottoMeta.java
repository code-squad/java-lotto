package lotto.domain;

import java.util.Objects;
import java.util.Random;

public class LottoMeta {

    private static final int RANDOM_LIMIT = 45;
    private int number;

    LottoMeta() {
        this(new Random().nextInt(RANDOM_LIMIT) + 1);
    }

    LottoMeta(int number) {
        validate(number);
        this.number = number;
    }

    private void validate(int number) {
        if (number <= 0 || number > RANDOM_LIMIT) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public String toString() {
        return String.valueOf(this.number);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoMeta lottoMeta = (LottoMeta) o;
        return number == lottoMeta.number;
    }

    @Override
    public int hashCode() {

        return Objects.hash(number);
    }
}
