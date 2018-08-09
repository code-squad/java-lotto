package lottoGame.model;

import java.util.*;

public class Lotto {

    static final int LOTTOSIZE = 6;
    private Set<LottoNumbers> lottoNums;

    public Lotto(Set<LottoNumbers> lottoNums) {
        if(lottoNums.size() < LOTTOSIZE) {
           throw new IllegalArgumentException();
        }
        this.lottoNums = lottoNums;
    }

    public static Lotto ofComma(String numbers) {
        Set<LottoNumbers> newLottoNums = new HashSet<>();
        for(String number : getStrings(numbers)) {
            newLottoNums.add(LottoNumbers.of(number));
        }

        return new Lotto(newLottoNums);
    }

    public static String[] getStrings(String numbers) {
        return numbers.split(",");
    }

    public List<LottoNumbers> getLottoNumbersToList() {
        return Arrays.asList(lottoNums.toArray(new LottoNumbers[lottoNums.size()]));
    }

    public boolean isNumberMatch(LottoNumbers otherNumber) {
        return lottoNums.contains(otherNumber);
    }
}
