package saru;

import org.junit.*;
import saru.domain.*;
import saru.view.*;

import java.util.*;

import static junit.framework.TestCase.assertEquals;

public class OutputTest {
    private static final int INIT_NUM = 6;

    private LottoMaker lottoMaker = LottoMaker.of();
    private List<LottoLine> lottoLines = new ArrayList<>();

    private String resultStr = "1, 2, 3, 4, 5, 6";
    private List<LottoNum> resultList = lottoMaker.makeManualLottoLine(resultStr);
    private LottoMatcher lottoMatcher = LottoMatcher.of(WinningLotto.of(resultList));
    private Result result;

    @Before
    public void init() {
        result = Result.of();

        String[] compareStr = {"3, 4, 5, 6, 9, 10", "3, 4, 5, 6, 9, 10",
                "3, 4, 5, 6, 1, 2", "3, 4, 5, 7, 1, 2", "7, 4, 5, 6, 8, 9",
                "1, 2, 3, 4, 5, 11"};

        for (String str : compareStr) {
            lottoLines.add(LottoLine.of(lottoMaker.makeManualLottoLine(str)));
        }

        // 매칭을 하는데 보너스 번호 일치 여부가 없음
        // 보너스 번호 일치 여부를 따로 받아야 할 것 같다.
        for (int i = 0; i < INIT_NUM; i++) {
            int bonusNum = 11;
            result.increaseHit(lottoMatcher.match(lottoLines.get(i)),
                    lottoLines.get(i).containsBonusNum(bonusNum));
        }
    }

    @Test
    public void 수익률계산() {
        Output.printCreatedNum(lottoLines);
        Output output = new Output(result, INIT_NUM);

        assertEquals(100 * ((5000 + 50000 * 2 + 1500000 + 30000000 + 2000000000)
                / (INIT_NUM * 1000)), output.calcIncome());
        System.out.println("수익률 : " + output.calcIncome() + " %");
    }
}
