package domain;

import vo.LottoNo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoFactory {
    private static final List<LottoNo> lottoNumbers;
    static {
        lottoNumbers = new ArrayList<>();
        for(int i = Lotto.MIN; i <= Lotto.MAX; i++){
            lottoNumbers.add(generateLottoNo(i));
        }
    }

    private static LottoNo generateLottoNo(int number){
        return new LottoNo(number);
    }

    private static Set<LottoNo> generateLottoNumbers(Set<Integer> numbers){
        Set<LottoNo> lottoNumbers = new HashSet<>();
        for (Integer number : numbers) {
            lottoNumbers.add(generateLottoNo(number));
        }
        return lottoNumbers;
    }

    static Lotto generateRandomLotto(){
        Collections.shuffle(lottoNumbers);
        return new Lotto(new HashSet<>(lottoNumbers.subList(0, Lotto.LOTTO_NUMBERS_SIZE)));
    }

    static Lotto generateTheLotto(Set<Integer> numbers){
        return new Lotto(generateLottoNumbers(numbers));
    }

    public static LottoBundle generateRandomLottoBundle(int count){
        LottoBundle randomLottoBundle = new LottoBundle();
        for(int i = 0; i < count; i++){
            randomLottoBundle.add(LottoFactory.generateRandomLotto());
        }
        return randomLottoBundle;
    }

    public static WinningLotto generateWinningLotto(Set<Integer> numbers, int bonusNumber){
        return new WinningLotto(generateLottoNumbers(numbers), generateLottoNo(bonusNumber));
    }

}
