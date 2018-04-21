package lotto.domain;

import java.util.List;
import java.util.stream.Stream;

public class Lotto {

    private List<Integer> selectedNumbers;


    public Lotto(List<Integer> selectedNumbers) {

        if (selectedNumbers == null || selectedNumbers.size() < 6)
            throw new IllegalArgumentException();

        this.selectedNumbers = selectedNumbers;
    }

    public WinningLotto getWinningLotto(int bonus) {
        return new WinningLotto(this, bonus);
    }

    public Stream<Integer> stream() {
        return selectedNumbers.stream();
    }

}
