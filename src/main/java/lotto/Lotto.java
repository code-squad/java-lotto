package lotto;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static lotto.LottoGame.assertMatch;

public class Lotto {

    List<Integer> selectedNumbers;

    public Lotto(List<Integer> selectedNumbers) {

        if (selectedNumbers == null || selectedNumbers.size() < 6)
            throw new IllegalArgumentException();

        this.selectedNumbers = selectedNumbers;
    }

    public List<Integer> getSelectedNumbers() {
        return selectedNumbers;
    }

    public List<Integer> getMatchNumberList(int[] ints) {
        return
                Stream.of(this)
                .flatMap(lotto -> lotto.getSelectedNumbers().stream())
                .filter(num -> assertMatch(ints, num))
                .collect(Collectors.toList());
    }

}
