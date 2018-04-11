package lotto.domain;

import java.util.Objects;
import java.util.Random;

public class LottoMeta {

    private static final int RANDOM_LIMIT = 45;
    private int number;

    LottoMeta() {
        this.number = new Random().nextInt(RANDOM_LIMIT) + 1;
        validate();
    }

    LottoMeta(int number) {
        this.number = number;
        validate();
    }

    private void validate() {
        if (this.number <= 0 || this.number > RANDOM_LIMIT) {
            throw new IllegalArgumentException();
        }
    }

    public int getNumber() {
        return this.number;
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
