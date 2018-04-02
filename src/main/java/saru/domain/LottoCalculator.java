package saru.domain;

import saru.*;

import java.util.*;

public class LottoCalculator {
    private List<LottoLine> lottoLines;

    private LottoCalculator(List<LottoLine> lottoLines) {
        this.lottoLines = lottoLines;
    }

    public static LottoCalculator of(List<LottoLine> lottoLines) {
        return new LottoCalculator(lottoLines);
    }

    public Result makeResult(String hitNumString, int bonusNum) {
        // 당첨번호와 같이 보너스 넘버를 입력받았다.
        Result result = Result.of();
        LottoMaker lottoMaker = LottoMaker.of();

        List<LottoNum> hitLottoLine = lottoMaker.makeManualLottoLine(hitNumString);

        // TODO 여기서 위닝로또?
        LottoMatcher lottoMatcher = LottoMatcher.of(WinningLotto.of(hitLottoLine));
        loopIncreaseHit(bonusNum, result, lottoMatcher);

        return result;
    }

    private void loopIncreaseHit(int bonusNum, Result result, LottoMatcher lottoMatcher) {
        // 결과 만들때도 보너스 여부 명시해야하는데..
        for (LottoLine lottoLine : this.lottoLines) {
            result.increaseHit(lottoMatcher.match(lottoLine),
                    isMatchBonusNum(lottoLine, bonusNum));
        }
    }

    private boolean isMatchBonusNum(LottoLine lottoLine, int bonusNum) {
        return lottoLine.containsBonusNum(bonusNum);
    }
}
