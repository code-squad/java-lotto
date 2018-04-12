package LottoGame;

import java.util.Collections;

/**
 * Created by hongjong-wan on 2018. 4. 7..
 */
public class Lotto {

    private static final int LOTTO_CHOOSE_COUNT = 6;
    private LottoNos lottoNos;

    public Lotto() {

        lottoNos = chooseSixNumber(suffle(createfortyFiveNumbers()));

        if (lottoNos.getSize() != LOTTO_CHOOSE_COUNT) {
            throw new IllegalArgumentException("로또는 6개의 숫자를 가져야만 합니다.");
        }
    }

    public Lotto(LottoNos lottoNos) {
        this.lottoNos = lottoNos;
    }

    public static LottoNos createfortyFiveNumbers() {
        LottoNos lottoNos = new LottoNos();
        for (int i = 1; i <= 45; i++) {
            lottoNos.add(new LottoNo(i));
        }
        return lottoNos;
    }

    public static LottoNos suffle(LottoNos lottoNos) {
        Collections.shuffle(lottoNos.getLottoNos());
        return lottoNos;
    }

    public static LottoNos chooseSixNumber(LottoNos lottoNos) {
        LottoNos resultLottoNos = new LottoNos();
        for (int i = 0; i < LOTTO_CHOOSE_COUNT; i++) {
            resultLottoNos.add(lottoNos.getLottoNos().get(i));
        }
        return resultLottoNos;
    }

    public int getMatchCount(WinningLotto winningLotto) {
        // 객체에게 메시지 전달
        return winningLotto.getMatchCount(lottoNos);
    }

    public boolean matchBonus(WinningLotto winningLotto) {
        // 객체에게 메시지 전달
        return winningLotto.matchBonus(lottoNos);
    }

    @Override
    public String toString() {
        return lottoNos + "";
    }

}