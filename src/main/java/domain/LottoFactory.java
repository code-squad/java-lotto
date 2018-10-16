package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoFactory {
    private static final List<Integer> lottoNumbers;
    static {
        lottoNumbers = new ArrayList<>();
        for(int i = Lotto.MIN; i <= Lotto.MAX; i++){
            lottoNumbers.add(i);
        }
    }

    static Lotto generateRandomLotto(){
        Collections.shuffle(lottoNumbers);
        return new Lotto(new ArrayList<>(lottoNumbers.subList(0, Lotto.LOTTO_NUMBERS_SIZE)));
    }

    public static Lotto generateTheLotto(List<Integer> numbers){
        return new Lotto(new ArrayList<>(numbers));
    }
}
