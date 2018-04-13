package lotto;

import java.util.*;

public class LottoNumbers {
    private List<Integer> numbers;

    public LottoNumbers(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public Collection<Integer> getNumbers() {
        return Collections.unmodifiableCollection(numbers);
    }

    public int match(LottoNumbers winningLotto) {
        Set<Integer> intersect = new HashSet<Integer>(numbers);
        intersect.retainAll(winningLotto.getNumbers());
        return intersect.size();
    }

    public int getMatchCount(LottoNumbers winLotto) {
        Set<Integer> intersect = new HashSet<Integer>(numbers);
        intersect.retainAll(winLotto.getNumbers());
        return intersect.size();
    }
}
