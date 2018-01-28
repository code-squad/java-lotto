package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Joeylee on 2018-01-13.
 */
public class Lotto {

    private List<LottoNo> lottoNumbers;
    private static final int LOTTO_NUMBER_SIZE = 6;

    public Lotto(List<Integer> numbers) {
        if(numbers.size() < LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException(String.format("최소 로또 숫자는 %s 입니다.",LOTTO_NUMBER_SIZE));
        }
        this.lottoNumbers = convertIntegerToLottoNo(numbers);
    }

    public List<LottoNo> convertIntegerToLottoNo(List<Integer> numbers) {
        return numbers.stream().map(LottoNo::new).collect(Collectors.toCollection(ArrayList::new));
    }
    @Override
    public String toString() {
        return String.join(", ", lottoNumbers.toString());
    }

    public int countMatchingAnswer(Lotto winningLotto) {
        int matchCount =0;
        for (LottoNo lottoNo : winningLotto.lottoNumbers) {
            if(this.lottoNumbers.contains(lottoNo)) {
                matchCount++;
            }
        }
        return matchCount;
    }



    public List<LottoNo> getLottoNumbers() {
        return lottoNumbers;
    }

    public boolean isBouseMatch(LottoNo bonusNumber) {
        return this.lottoNumbers.contains(bonusNumber);
    }
}
