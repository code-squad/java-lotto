package saru.domain;

import java.util.List;

// 유틸로 따로 뺄까 생각했지만 비교 기준이 되는 당첨 번호는 만들어 두는게 맞는 것 같다.
public class LottoMatcher {
    private List<LottoNum> hitLottoLine;

    private LottoMatcher(List<LottoNum> lottoLine) {
        this.hitLottoLine = lottoLine;
    }

    public static LottoMatcher of(List<LottoNum> lottoLine) {
        return new LottoMatcher(lottoLine);
    }

    public int match(LottoLine lottoLine) {
        int matchNum = 0;

        for (LottoNum lottoNum : hitLottoLine) {
            if (lottoLine.getNumbers().contains(lottoNum)) {
                matchNum++;
            }
        }

        return matchNum;
    }
}
