package saru;

import saru.domain.*;

import java.util.*;

import static junit.framework.TestCase.assertEquals;

import org.junit.Test;
import org.junit.Before;

public class LottoMainTest {
    private LottoMaker lottoMaker = LottoMaker.of();
    private List<LottoLine> lottoLines = new ArrayList<>();

    private String resultStr = "1, 2, 3, 4, 5, 6";
    private LottoMatcher lottoMatcher = LottoMatcher.of(lottoMaker.makeManualLottoLine(resultStr));
    private Result result;

    @Before
    public void init() {
        result = Result.of();

        String[] compareStr = {"3, 4, 5, 6, 9, 10", "3, 4, 5, 6, 9, 10",
                "3, 4, 5, 6, 1, 2", "3, 4, 5, 7, 1, 2", "7, 4, 5, 6, 8, 9"};

        for (String str : compareStr) {
            lottoLines.add(LottoLine.of(lottoMaker.makeManualLottoLine(str)));
        }

        for (int i = 0; i < 5; i++) {
            result.increaseHit(lottoMatcher.match(lottoLines.get(i)));
        }
    }

    @Test
    public void 로또번호() {
        assertEquals(10, LottoNum.of(10).getNumber());
    }

    @Test
    public void 번호자동생성() {
        List<LottoNum> lottoNumList = LottoMaker.of().makeLottoList();
        assertEquals(6, lottoNumList.size());
    }

    @Test
    public void 로또자동생성여러개() {
        LottoMaker lottoMaker = LottoMaker.of();
        List<LottoLine> lottoNumList = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            lottoNumList.add(LottoLine.of(lottoMaker.makeLottoList()));
        }

        assertEquals(10, lottoNumList.size());
    }

    @Test
    public void 당첨번호갯수() {
        String compareStr = "1, 2, 3, 8, 9, 10";
        LottoMaker lottoMaker = LottoMaker.of();
        List<LottoNum> lottoLine = lottoMaker.makeManualLottoLine(compareStr);

        LottoMatcher lottoMatcher = LottoMatcher.of(lottoMaker.makeManualLottoLine(resultStr));
        int matchNum = lottoMatcher.match(LottoLine.of(lottoLine));

        assertEquals(3, matchNum);
    }

    @Test
    public void 결과셋일치() {
        assertEquals(1, result.getThreeHit());
    }

    @Test
    public void 결과넷일치() {
        assertEquals(2, result.getFourHit());
    }

    @Test
    public void 결과다섯일치() {
        assertEquals(1, result.getFiveHit());
    }

    @Test
    public void 결과여섯일치() {
        assertEquals(1, result.getSixHit());
    }
}