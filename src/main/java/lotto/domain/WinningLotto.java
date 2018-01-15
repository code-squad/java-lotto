package lotto.domain;

import lotto.domain.enums.LottoCorrectCount;

import java.util.Arrays;
import java.util.List;

import static lotto.domain.enums.LottoCorrectCount.FIVE_DOUBLE;
import static lotto.domain.enums.LottoCorrectCount.FOUR;

public class WinningLotto {
    private static List<Integer> winningLottos;
    private static int bonusBall;

    private WinningLotto(List<Integer> winningLottos, int bonusBall) {
        this.winningLottos = winningLottos;
        this.bonusBall = bonusBall;
    }

    public static WinningLotto generate(List<Integer> winningLottos, int bonusBall) {
        return new WinningLotto(winningLottos, bonusBall);
    }

    //TODO: 앞단에 3개 이하는 들어오지 못하도록 막는 로직이 필요
    public static LottoCorrectCount match(Lotto lotto) {
        int count = (int) winningLottos.stream().filter(lotto.getNumbers()::contains).count();

        if(FOUR.isCorrect(count) && lotto.hasBonusBall(bonusBall)) return FIVE_DOUBLE;
        return Arrays.stream(LottoCorrectCount.values())
                .filter(lottoCorrectCount -> lottoCorrectCount.isCorrect(count))
                .findFirst().get();
    }
}
