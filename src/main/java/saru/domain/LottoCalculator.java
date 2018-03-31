package saru.domain;

import saru.*;
import saru.view.*;

import java.util.*;

public class LottoCalculator {
    private List<LottoLine> lottoLines;

    private LottoCalculator(List<LottoLine> lottoLines) {
        this.lottoLines = lottoLines;
    }

    public static LottoCalculator of(List<LottoLine> lottoLines) {
        return new LottoCalculator(lottoLines);
    }

    public Result makeResult(String hitNumString) {
        Result result = Result.of();
        LottoMaker lottoMaker = LottoMaker.of();

        List<LottoNum> hitLottoLine = lottoMaker.makeManualLottoLine(hitNumString);
        LottoMatcher lottoMatcher = LottoMatcher.of(hitLottoLine);

        for (LottoLine lottoLine : this.lottoLines) {
            result.increaseHit(lottoMatcher.match(lottoLine));
        }
        return result;
    }
}
