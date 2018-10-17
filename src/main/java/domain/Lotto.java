package domain;

import dto.LottoDto;

import static util.RandomGenerator.*;

import java.util.*;

public class Lotto {

    private List<Integer> lotto;

    private Lotto(List<Integer> lotto) {
        Collections.sort(lotto);
        this.lotto = lotto;
    }

    public static Lotto init() {
        return new Lotto(makeLotto());
    }

    public static Lotto initArtifitial(List<Integer> lotto) {
        return new Lotto(lotto);
    }

    public static List<Integer> makeLotto() {
        Set<Integer> lotto = new HashSet<>();
        while (lotto.size() < 6) {
            lotto.add(generateLottoNum());
        }

        return new ArrayList<>(lotto);
    }

    public int compareLottoNumbs(Lotto lotto) {
        int result = 0;
        for (int num : lotto.lotto) {
            result += checkNum(num);
        }

        return result;
    }

    private int checkNum(int num) {
        if(this.lotto.contains(num))
            return 1;
        return 0;
    }

    public LottoDto toLottoDto() {
        return LottoDto.init(this.lotto);
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
        StringBuilder sb = new StringBuilder("[");

        for (int i = 0; i < lotto.size(); i++) {
            sb.append(lotto.get(i));
            if (i < lotto.size() - 1) sb.append(", ");
        }
        sb.append("]");

        return sb.toString();
    }

}
