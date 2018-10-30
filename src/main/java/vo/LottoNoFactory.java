package vo;

import domain.Lotto;

import java.util.*;

public class LottoNoFactory {
    private static final List<LottoNo> lottoNumbers;
    static {
        lottoNumbers = new ArrayList<>();
        for(int i = Lotto.MIN; i <= Lotto.MAX; i++){
            lottoNumbers.add(new LottoNo(i));
        }
    }

    public static LottoNo getLottoNo(int number){
        for (LottoNo lottoNumber : lottoNumbers) {
            if(lottoNumber.isEqual(number)) return lottoNumber;
        }
        throw new IllegalArgumentException("Invalid number");
    }

    public static Set<LottoNo> getMultiLottoNo(Set<Integer> numbers){
        Set<LottoNo> lottoNumbers = new HashSet<>();
        for (Integer number : numbers) {
            lottoNumbers.add(getLottoNo(number));
        }
        return lottoNumbers;
    }

    public static Set<LottoNo> getRandomMultiLottoNo(){
        Collections.shuffle(lottoNumbers);
        return new HashSet<>(lottoNumbers.subList(0, Lotto.LOTTO_NUMBERS_SIZE));
    }
}
