package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Joeylee on 2018-01-13.
 */
public class Lotto {

    private List<Integer> lottoNumbers;
    private static final int LOTTO_NUMBER_SIZE = 6;

    public Lotto(List<Integer> numbers) {
        if(numbers.size() < LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException(String.format("최소 로또 숫자는 %s 입니다.",LOTTO_NUMBER_SIZE));
        }
        this.lottoNumbers = numbers;
    }

    @Override
    public String toString() {
        return String.join(", ", lottoNumbers.toString());
    }

    public int countMatchingAnswer(Lotto matchingLotto) {
        int matchCount =0;
        for (Integer integer : matchingLotto.lottoNumbers) {
            if(this.lottoNumbers.contains(integer)) {
                matchCount++;
            }
        }
        return matchCount;
    }
}
