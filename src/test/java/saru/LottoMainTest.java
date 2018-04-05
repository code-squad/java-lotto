package saru;

import saru.domain.*;

import java.util.*;

import org.junit.*;

import static junit.framework.TestCase.assertEquals;

public class LottoMainTest {
    private static final int INIT_NUM = 6;
    private static final int BONUS_NUMBER = 11;

    private LottoMaker lottoMaker = LottoMaker.of();
    private List<LottoLine> lottoLines = new ArrayList<>();

    private String resultStr = "1, 2, 3, 4, 5, 6";
    private List<LottoNum> resultList = lottoMaker.makeManualLottoNums(resultStr);
    private WinningLotto winningLotto = WinningLotto.of(resultList, LottoNum.of(BONUS_NUMBER));
    private Result result = Result.of(INIT_NUM);

    @Before
    public void init() {
        String[] compareStr = {"3, 4, 5, 6, 9, 10", "3, 4, 5, 6, 9, 10",
                "3, 4, 5, 6, 1, 2", "3, 4, 5, 7, 1, 2", "7, 4, 5, 6, 8, 9",
                "1, 2, 3, 4, 5, 11"};

        for (String str : compareStr) {
            lottoLines.add(LottoLine.of(lottoMaker.makeManualLottoNums(str)));
        }

        for (int i = 0; i < INIT_NUM; i++) {
            result.increaseHit(winningLotto.match(lottoLines.get(i)),
                    winningLotto.matchBonus(lottoLines.get(i)));
        }
    }

    @Test
    public void 로또번호() {
        assertEquals(10, LottoNum.of(10).getNum());
    }

    @Test(expected = IllegalArgumentException.class)
    public void 로또번호실패_최소미만() {
        LottoNum.of(0).getNum();
    }

    @Test(expected = IllegalArgumentException.class)
    public void 로또번호실패_최대초과() {
        LottoNum.of(46).getNum();
    }

    @Test
    public void 번호자동생성() {
        List<LottoNum> lottoNumList = LottoMaker.of().makeAutoLottoNums();
        assertEquals(6, lottoNumList.size());
    }

    @Test
    public void 로또자동생성여러개() {
        LottoMaker lottoMaker = LottoMaker.of();
        List<LottoLine> lottoNumList = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            lottoNumList.add(LottoLine.of(lottoMaker.makeAutoLottoNums()));
        }

        assertEquals(10, lottoNumList.size());
    }

    @Test
    public void 당첨번호갯수_여섯() {
        String compareStr = "1, 2, 3, 4, 5, 6";
        List<LottoNum> lottos = lottoMaker.makeManualLottoNums(compareStr);

        int matchNum = winningLotto.match(LottoLine.of(lottos));
        assertEquals(6, matchNum);
    }

    @Test
    public void 당첨번호갯수_없음() {
        String compareStr = "11, 12, 13, 18, 19, 20";
        List<LottoNum> lottos = lottoMaker.makeManualLottoNums(compareStr);

        int matchNum = winningLotto.match(LottoLine.of(lottos));
        assertEquals(0, matchNum);
    }

    @Test
    public void 당첨번호갯수() {
        String compareStr = "1, 2, 3, 8, 9, 10";
        List<LottoNum> lottos = lottoMaker.makeManualLottoNums(compareStr);

        int matchNum = winningLotto.match(LottoLine.of(lottos));
        assertEquals(3, matchNum);
    }

    @Test
    public void 결과셋일치() {
        assertEquals(1, result.getRankHitNum(Rank.FIFTH));
    }

    @Test
    public void 결과넷일치() {
        assertEquals(2, result.getRankHitNum(Rank.FOURTH));
    }

    @Test
    public void 결과다섯일치() {
        assertEquals(1, result.getRankHitNum(Rank.SECOND));
    }

    @Test
    public void 결과다섯일치_보너스번호() {
        assertEquals(1, result.getRankHitNum(Rank.SECOND));
    }

    @Test
    public void 결과여섯일치() {
        assertEquals(1, result.getRankHitNum(Rank.FIRST));
    }

    @Test
    public void 수익률계산() {
        assertEquals(100 * ((5000 + 50000 * 2 + 1500000 + 30000000 + 2000000000)
                / (INIT_NUM * 1000)), result.calcIncome());
    }
}