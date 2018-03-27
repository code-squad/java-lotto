package domain;

import dto.LottoDto;

public class WinningLotto {
    private Lotto lotto;
    private int bonusNumber;

    // TODO : 생성자 변경될 수 있음 (List<Integer> 받는걸로)
    public WinningLotto(Lotto lotto, int bonusNumber) {
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    // TODO : 리턴 타입이 변경될 수 있음(convertLottoDto -> Result 관련 객체로)
    public int match(Lotto otherLotto) {
        return lotto.match(otherLotto);
    }

    private LottoDto convertLottoDto(int matchPoint) {
        return new LottoDto(matchPoint);
    }

    @Override
    public String toString() {
        return "WinningLotto{" + "lotto=" + lotto.toString() + ", bonusNumber=" + bonusNumber + '}';
    }
}
