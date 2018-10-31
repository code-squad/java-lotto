package lotto.domain;
import lotto.domain.vo.LottoNumber;

import java.util.*;

public class Lotto {
    private static final int MAX_LOTTO = 45;
    private static final int MIN_LOTTO = 1;
    private static final int COUNT_LOTTO = 6;

    private static List<Integer> numbers = new ArrayList<>();

    static {
        for (int i = MIN_LOTTO; i <= MAX_LOTTO; i++) {
            numbers.add(i);
        }
    }

    private List<LottoNumber> lotto;

    private Lotto(List<Integer> numbers) {
        lotto = new ArrayList<>();
        numbers.forEach(number -> lotto.add(LottoNumber.ofInteger(number)));
        Collections.sort(lotto);
    }

    public static Lotto generateLottoNumber() {
        Collections.shuffle(numbers);
        return new Lotto(numbers.subList(0,COUNT_LOTTO));
    }

    public static Lotto enterNumberOfLotto(String input) {
        String inputTrim = input.trim();
        Set<Integer> lotto = new HashSet<>();
        for (String s : inputTrim.split(",")) {
            lotto.add(Integer.parseInt(s));
        }

        if(lotto.size() != COUNT_LOTTO) {
            throw new NotTypeLottoException("중복되지 않은 6개의 숫자를 입력하세요");
        }

        return new Lotto(new ArrayList<>(lotto));
    }

    public boolean isContainBonusNumber(int number) {
        return lotto.contains(LottoNumber.ofInteger(number));
    }

    public int compare(Lotto other){
        return other.compare(lotto);
    }

    private int compare(List<LottoNumber> other) {
        return (int) other.stream().filter(number -> lotto.contains(number)).count();
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
