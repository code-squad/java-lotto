package saru.domain;

import java.util.List;

// 유틸로 따로 뺄까 생각했지만 비교 기준이 되는 당첨 번호는 만들어 두는게 맞는 것 같다.
public class LottoMatcher {
    private List<LottoNumber> hitNumberList;

    private LottoMatcher(List<LottoNumber> numberList) {
        this.hitNumberList = numberList;
    }

    public static LottoMatcher of(List<LottoNumber> numberList) {
        return new LottoMatcher(numberList);
    }

    public int match(List<LottoNumber> inputNumberList) {
        int matchNum = 0;

        for (LottoNumber lottoNumber : hitNumberList) {
            if (inputNumberList.contains(lottoNumber)) {
                matchNum++;
            }
        }

        return matchNum;
    }
}
