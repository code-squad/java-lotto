package saru;

import java.sql.*;
import java.util.*;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.*;
import saru.domain.*;

public class LottoDBTest {
    private LottoDB lottoDB;

    @Before
    public void init() {
        String addr = "jdbc:mysql://localhost/LOTTO";
        String user = "saru";
        String pw = "kke";

        LottoDB.initLottoDB(addr, user, pw);
        lottoDB = LottoDB.getInstance();
    }

    @Test
    public void createConnection() {
        Connection conn = lottoDB.createConnection();
        assertNotNull(conn);
    }

    @Test
    public void insertLottoNum() {
        LottoMaker lottoMaker = LottoMaker.of();
        List<LottoNum> lottoNums = lottoMaker.makeManualLottoNums("1,2,3,4,5,6");

        LottoLineDAO lottoLineDAO = LottoLineDAO.getInstance();
        lottoLineDAO.insertLottoNums(lottoNums);
    }

    @Test
    public void insertLottoLines() {
        LottoMaker lottoMaker = LottoMaker.of();
        List<LottoLine> lottoLines = lottoMaker.makeAutoLottoLines(10);

        LottoLineDAO lottoLineDAO = LottoLineDAO.getInstance();
        lottoLineDAO.insertLottoLines(lottoLines);
        System.out.println(lottoLines);
    }

    @Test
    public void getLottoLines() {
        LottoLineDAO lottoLineDAO = LottoLineDAO.getInstance();

        LottoMaker lottoMaker = LottoMaker.of();
        List<LottoNum> lottoNums = lottoMaker.makeManualLottoNums("9,10,11,12,13,14");
        lottoLineDAO.insertLottoNums(lottoNums);

        List<LottoLine> lottoLines = lottoLineDAO.getLottoLines();
        System.out.println(lottoLines);
    }

    @Test
    public void getLottoLinesFail() {
        LottoLineDAO lottoLineDAO = LottoLineDAO.getInstance();
        lottoLineDAO.clear();
        List<LottoLine> lottoLines = lottoLineDAO.getLottoLines();
        assertEquals(0, lottoLines.size());
    }

    @Test
    public void lottoLinesPrepareStatementFail() {
        Connection conn = lottoDB.createConnection();
        List<LottoLine> lottoLines = null;

        String sql = "SELECT NOTEXIST * FROM NOTEXIST";
        LottoLineDAO lottoLineDAO = LottoLineDAO.getInstance();
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            lottoLines = lottoLineDAO.resultSetToLottoLines(pstmt);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        assertEquals(0, lottoLines.size());
    }

    @Test
    public void insertResult() {
        Result result = Result.of(6);

        resultTestInit(result);

        ResultDAO resultDAO = ResultDAO.getInstance();
        resultDAO.insertResult(result);
    }

    private void resultTestInit(Result result) {
        LottoMaker lottoMaker = LottoMaker.of();
        List<LottoLine> lottoLines = new ArrayList<>();

        String resultStr = "1, 2, 3, 4, 5, 6";
        List<LottoNum> resultList = lottoMaker.makeManualLottoNums(resultStr);
        WinningLotto winningLotto = WinningLotto.of(resultList, LottoNum.of(11));

        String[] compareStr = {"3, 4, 5, 6, 9, 10", "3, 4, 5, 6, 9, 10",
                "3, 4, 5, 6, 1, 2", "3, 4, 5, 7, 1, 2", "7, 4, 5, 6, 8, 9",
                "1, 2, 3, 4, 5, 11"};

        for (String str : compareStr) {
            lottoLines.add(LottoLine.of(lottoMaker.makeManualLottoNums(str)));
        }

        for (int i = 0; i < 6; i++) {
            result.increaseHit(winningLotto.match(lottoLines.get(i)),
                    winningLotto.matchBonus(lottoLines.get(i)));
        }
    }
}