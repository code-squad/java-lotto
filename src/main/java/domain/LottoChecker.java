package domain;

import dto.StrikeDto;

class LottoChecker {
    private final WinningLotto winningLotto;

    LottoChecker(WinningLotto winningLotto) {
        this.winningLotto = winningLotto;
    }

    StrikeDto checkLotto(Lotto lotto) {
        int strikePoint = lotto.strikeCheck(winningLotto);
        boolean strikeBonus = winningLotto.bonusCheck(lotto);
        return new StrikeDto(strikePoint, strikeBonus);
    }
}
