package lotto;

import dto.LottoDto;
import util.Utility;
import vo.Num;

import java.util.*;

public class Lotto {
    private static final int LOTTO_NUMBER_COUNT = 45;
    private static List<Num> initLottoNumber = new ArrayList<>();
    private Set<Num> lotto;

    static {
        for (int i = 1; i <= LOTTO_NUMBER_COUNT; i++) {
            initLottoNumber.add(new Num(i));
        }
    }

    Lotto() {
        Collections.shuffle(initLottoNumber);
        lotto = new TreeSet<>(initLottoNumber.subList(0, 6));
    }

    Lotto(Set<Num> winningLotto) {
        lotto = winningLotto;
    }


    public LottoDto toDto() {
        return new LottoDto(lotto);
    }

}
