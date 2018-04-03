package saru.domain;

import saru.Result;

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

        List<LottoNum> hitLottoLine = lottoMaker.makeManualLottoLine(hitNumber);
        WinningLotto winningLotto = WinningLotto.of(hitLottoLine, bonusNumber);

        loopIncreaseHit(result, winningLotto);

        return result;
    }

    private void loopIncreaseHit(Result result, WinningLotto winningLotto) {
        for (LottoLine lottoLine : lottoLines) {
            result.increaseHit(winningLotto.match(lottoLine),
                    winningLotto.matchBonus(lottoLine));
        }
    }
}
