package lotto.domain;

import java.util.List;
import java.util.Objects;

public class WinningLotto {

    private final Lotto lotto;
    private final String bonusNumber;

    public WinningLotto(List<String> numbers, String bonusNumber) {
        this.lotto = new Lotto(numbers);

        valid(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public Rank match(Lotto lotto) {
        return Rank.valueOf(this.lotto.countOfMatch(lotto), this.lotto.contains(bonusNumber));
    }

    private void valid(String bonusNumber) {
        Integer number = Integer.parseInt(bonusNumber);

        if (number < 1 || 45 < number) {
            throw new IllegalArgumentException();
        }

        if (lotto.contains(bonusNumber)) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof WinningLotto)) return false;
        WinningLotto that = (WinningLotto) o;
        return Objects.equals(lotto, that.lotto);
    }

    @Override
    public int hashCode() {

        return Objects.hash(lotto);
    }
}
