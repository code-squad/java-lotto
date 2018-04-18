package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static lotto.domain.LottoGame.assertMatch;


public class Lotto {

    List<Integer> selectedNumbers;
    Rank rank;


    public Lotto(List<Integer> selectedNumbers) {

        if (selectedNumbers == null || selectedNumbers.size() < 6)
            throw new IllegalArgumentException();

        this.selectedNumbers = selectedNumbers;
    }

    private Lotto(List<Integer> selectedNumbers, int matches, boolean bonus) {

        if (selectedNumbers == null || selectedNumbers.size() < 6)
            throw new IllegalArgumentException();

        this.selectedNumbers = selectedNumbers;
        this.rank = matchRank(matches, bonus);
    }

    public Lotto getMatchNumber(int[] ints, int bonus) {
        boolean isBonus = false;
        int matches = stream()
                .filter(num -> assertMatch(ints, num))
                .collect(Collectors.toList())
                .size();

        if (matches == 5) {
            isBonus =
                    stream()
                    .anyMatch(num -> num == bonus);
        }

        return new Lotto(selectedNumbers, matches, isBonus);
    }

    public Rank getRank() {
        return rank;
    }

    public Stream<Integer> stream() {
        return selectedNumbers.stream();
    }

    private static Rank matchRank(int matches, boolean isBonus) {
        Rank rank = Rank.valueOf(matches, isBonus);

        switch (rank) {
            case FIRST:
                return Rank.FIRST;
            case SECOND:
                if (isBonus) return Rank.SECOND;
                return Rank.THIRD;
            case THIRD:
                return Rank.THIRD;
            case FOURTH:
                return Rank.FOURTH;
            case FIFTH:
                return Rank.FIFTH;
            default:
                return Rank.MISS;
        }
    }

}
