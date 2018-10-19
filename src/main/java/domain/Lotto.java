package domain;

import dto.LottoDto;
import vo.No;

import static util.RandomGenerator.*;

import java.util.*;

public class Lotto {

    public static final int LOTTO_SIZE = 6;

    private List<No> lotto;

    private Lotto(List<No> lotto) {
        Collections.sort(lotto);
        this.lotto = lotto;
    }

    public static Lotto init() {
        return new Lotto(makeLotto());
    }

    public static Lotto initArtifitial(List<No> lotto) {
        return new Lotto(lotto);
    }

    public static List<No> makeLotto() {
        Set<No> lotto = new HashSet<>();
        while (lotto.size() < LOTTO_SIZE) {
            lotto.add(new No(generateLottoNum()));
        }

        return new ArrayList<>(lotto);
    }

    public int compareLottoNumbs(Lotto lotto) {
        int result = 0;
        for (No num : lotto.lotto) {
            result += checkNums(num);
        }

        return result;
    }

    private int checkNums(No num) {
        if (this.lotto.contains(num))
            return 1;
        return 0;
    }

    public Boolean checkBonusNum(No BonusNum) {
        return this.lotto.contains(BonusNum);
    }

    public LottoDto toLottoDto() {
        return LottoDto.init(lotto);
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
