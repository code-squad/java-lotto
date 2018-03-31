package saru;

import org.junit.Before;
import org.junit.Test;
import saru.domain.LottoLine;
import saru.domain.LottoMaker;
import saru.domain.LottoMatcher;
import saru.view.Output;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

public class OutputTest {
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
    public void 수익률계산() {
        Output.printCreatedNum(lottoLines);
        Output output = new Output(result, 5);
        // 100 * sumMoney / (this.buyNum * 1000);
        // 100 * 2001605000 / (5 * 1000);
        assertEquals(100 * (2001605000 / (5 * 1000)), output.calcIncome());
        System.out.println("수익률 : " + output.calcIncome() + " %");
    }
}
