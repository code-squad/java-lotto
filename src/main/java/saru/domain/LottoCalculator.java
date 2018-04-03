package saru.domain;

import saru.Result;

import java.util.List;

public class LottoCalculator {
    private List<LottoLine> manualLines;
    private List<LottoLine> autoLines;

    private LottoCalculator(List<LottoLine> manualLines, List<LottoLine> autoLines) {
        this.manualLines = manualLines;
        this.autoLines = autoLines;
    }

    public static LottoCalculator of(List<LottoLine> manualLines, List<LottoLine> autoLines) {
        return new LottoCalculator(manualLines, autoLines);
    }

    public Result makeResult(int buyNum, String hitNumber, int bonusNumber) {
        Result result = Result.of(buyNum);
        LottoMaker lottoMaker = LottoMaker.of();

        List<LottoNum> hitLottoLine = lottoMaker.makeManualLottoNums(hitNumber);
        WinningLotto winningLotto = WinningLotto.of(hitLottoLine, bonusNumber);

        loopIncreaseHit(result, winningLotto);

        return result;
    }

    private void loopIncreaseHit(Result result, WinningLotto winningLotto) {
        for (LottoLine lottoLine : manualLines) {
            result.increaseHit(winningLotto.match(lottoLine),
                    winningLotto.matchBonus(lottoLine));
        }

        for (LottoLine lottoLine : autoLines) {
            result.increaseHit(winningLotto.match(lottoLine),
                    winningLotto.matchBonus(lottoLine));
        }
    }
}
