package lotto.domain;
import java.util.*;

import static lotto.util.Constant.LOTTO_MAX;
import static lotto.util.Constant.LOTTO_MIN;
import static lotto.util.Constant.MAX_LOTTO_COUNT;

public class Lotto  {
    private List<LottoNumber> lotto;
    private static List<Integer> numbers = new ArrayList<>();

    static {
        for (int i = LOTTO_MIN; i <= LOTTO_MAX; i++) {
            numbers.add(i);
        }
    }

    private Lotto(List<Integer> numbers) {
        lotto = new ArrayList<>();
        for (Integer number : numbers) {
            lotto.add(new LottoNumber(number));
        }
        Collections.sort(lotto);
    }

    public static Lotto generateLottoNumber() {
        Collections.shuffle(numbers);
        return new Lotto(numbers.subList(0,MAX_LOTTO_COUNT));
    }

    public static Lotto winningLotto(String winText) {
        Set<Integer> winLotto = new HashSet<>();
        for (String s : winText.split(",")) {
            winLotto.add(Integer.parseInt(s));
        }

        if(winLotto.size() != MAX_LOTTO_COUNT) {
            throw new IllegalArgumentException();
        }

        return new Lotto(new ArrayList<>(winLotto));
    }

    public int compare(Lotto other){
        return other.compare(lotto);
    }

    public int compare(List<LottoNumber> other) {
        int count = 0;
        for (LottoNumber lottoNumber : other) {
            if (lotto.contains(lottoNumber)) {
                count++;
            }
        }
        return count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto1 = (Lotto) o;
        return Objects.equals(lotto, lotto1.lotto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lotto);
    }

    @Override
    public String toString() {
        return "" + lotto;
    }
}
