package domain;

import java.util.*;

public class LottoFactory {
    private static final List<Integer> lottoNumbers;
    static {
        lottoNumbers = new ArrayList<>();
        for(int i = Lotto.MIN; i <= Lotto.MAX; i++){
            lottoNumbers.add(i);
        }
    }

    public static Lotto generateRandomLotto(){
        Collections.shuffle(lottoNumbers);
        return new Lotto(new HashSet<>(lottoNumbers.subList(0, Lotto.LOTTO_NUMBERS_SIZE)));
    }

    public static Lotto generateTheLotto(Set<Integer> numbers){
        return new Lotto(numbers);
    }

    public static WinningLotto generateWinningLotto(Set<Integer> numbers, int bonusNumber){
        return new WinningLotto(numbers, bonusNumber);
    }
}
