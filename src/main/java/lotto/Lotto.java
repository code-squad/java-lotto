package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
        List<LottoNo> lottoNos = new ArrayList<>();
        for (Integer integer : numbers) {
            lottoNos.add(new LottoNo(integer));
        }
        return lottoNos;
    }
    @Override
    public String toString() {
        return String.join(", ", lottoNumbers.toString());
    }

    public int countMatchingAnswer(Lotto lotto) {
        int matchCount =0;
        for (LottoNo lottoNo : lotto.getLottoNumbers()) {
            if(lottoNo.matchInList(this.lottoNumbers)) {
                matchCount++;
            }
        }
        return matchCount;
    }



    public List<LottoNo> getLottoNumbers() {
        return lottoNumbers;
    }

    public boolean isBouseMatch(LottoNo bonusNumber) {
        return bonusNumber.matchInList(this.lottoNumbers);
    }
}
