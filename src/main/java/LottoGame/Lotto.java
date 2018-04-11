package LottoGame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by hongjong-wan on 2018. 4. 7..
 */
public class Lotto {

    private static final int LOTTO_CHOOSE_COUNT = 6;
    private List<Integer> numbers;

    public Lotto() {

        numbers = chooseSixNumber(suffle(createfortyFiveNumbers()));

        if (numbers.size() != LOTTO_CHOOSE_COUNT) {
            throw new IllegalArgumentException("로또는 6개의 숫자를 가져야만 합니다.");
        }
    }

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public static List<Integer> createfortyFiveNumbers() {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= 45; i++) {
            numbers.add(i);
        }
        return numbers;
    }

    public static List<Integer> suffle(List<Integer> numbers) {
        Collections.shuffle(numbers);
        return numbers;
    }

    public static List<Integer> chooseSixNumber(List<Integer> numbers) {
        List<Integer> lotto = new ArrayList<>();
        for (int i = 0; i < LOTTO_CHOOSE_COUNT; i++) {
            int lottoNumber = numbers.get(i);
            lotto.add(lottoNumber);
        }
        return lotto;
    }

    public int getMatchCount(WinningLotto winningLotto) {
        // 객체에게 메시지 전달
        return winningLotto.getMatchCount(numbers);
    }

    public boolean matchBonus(WinningLotto winningLotto) {
        // 객체에게 메시지 전달
        return winningLotto.matchBonus(numbers);
    }

    @Override
    public String toString() {
        return numbers + "";
    }

}