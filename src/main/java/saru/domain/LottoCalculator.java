package saru.domain;

import saru.Result;

import java.util.ArrayList;
import java.util.List;

public class LottoCalculator {
    private List<LottoLine> lottoLines;

    private LottoCalculator(List<LottoLine> lottoLines) {
        this.lottoLines = lottoLines;
    }

    public static LottoCalculator of(List<LottoLine> lottoLines) {
        return new LottoCalculator(lottoLines);
    }

    public Result makeResult(int buyNum, String hitNumber, int bonusNumber) {
        Result result = Result.of(buyNum);
        LottoMaker lottoMaker = LottoMaker.of();

        WinningLotto winningLotto = makeWinningLotto(hitNumber, bonusNumber, lottoMaker);
        loopIncreaseHit(result, winningLotto);

        return result;
    }

    private WinningLotto makeWinningLotto(String hitNumber, int bonusNumber, LottoMaker lottoMaker) {
        List<LottoNum> hitLottoLine;
        WinningLotto winningLotto;
        try {
            hitLottoLine = makeHitLine(hitNumber, lottoMaker);
            winningLotto = WinningLotto.of(hitLottoLine, LottoNum.of(bonusNumber));
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e);
        }

        return winningLotto;
    }

    private List<LottoNum> makeHitLine(String hitNumber, LottoMaker lottoMaker) {
        List<LottoNum> hitLottoLine;
        try {
            hitLottoLine = lottoMaker.makeManualLottoNums(hitNumber);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e);
        }

        return hitLottoLine;
    }

    private void loopIncreaseHit(Result result, WinningLotto winningLotto) {
        for (LottoLine lottoLine : lottoLines) {
            result.increaseHit(winningLotto.match(lottoLine),
                    winningLotto.matchBonus(lottoLine));
        }
    }
}
