package lotto;

import dto.LottoDto;
import util.Utility;
import vo.Num;

import java.util.*;

public class Lotto {
    private static final int LOTTO_NUMBER_COUNT = 45;
    private static List<Num> initLottoNumber = new ArrayList<>();
    private List<Num> lotto;

    static {
        for (int i = 1; i <= LOTTO_NUMBER_COUNT; i++) {
            initLottoNumber.add(new Num(i));
        }
    }

    Lotto() {
        Collections.shuffle(initLottoNumber);
        lotto = new ArrayList<>(initLottoNumber.subList(0, 6));
        Collections.sort(lotto);
    }

    Lotto(Set<Num> winningLotto) {
        lotto = new ArrayList<>(winningLotto);
    }

    public Num getIndex(int index) {
        return lotto.get(index);
    }

    public int gameStart(Lotto winningLotto) {
        int count = 0;
        for (int i = 0; i < 6; i++) {
            if (lotto.contains(winningLotto.getIndex(i)))
                count++;
        }
        return count;
    }

    public LottoDto toDto() {
        return new LottoDto(lotto);
    }
}
