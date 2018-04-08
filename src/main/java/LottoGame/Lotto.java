package LottoGame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by hongjong-wan on 2018. 4. 7..
 */
public class Lotto {

    private List<Integer> numbers;

    public Lotto() {
        numbers = chooseSixNumber(suffle(createfortyFiveNumbers()));
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
        for (int i = 0; i <= 5; i++) {
            int lottoNumber = numbers.get(i);
            lotto.add(lottoNumber);
        }
        return lotto;
    }

    public int getMatchCount(WinningLotto winningLotto) {
        List<Integer> winningNumber = winningLotto.getNumbers();
        int matchCount = 0;
        for(Integer lottoNumber : numbers) {
            if(winningNumber.contains(lottoNumber)) {
                matchCount++;
            }
        }
        return matchCount;
    }

    @Override
    public String toString() {
        return numbers + "";
    }

}
