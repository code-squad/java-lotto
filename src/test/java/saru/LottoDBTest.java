package saru;

import java.sql.*;
import java.util.*;

import static org.junit.Assert.assertNotNull;

import org.junit.*;
import saru.domain.*;

public class LottoDBTest {
    private LottoDB lottoDB = LottoDB.getInstance();

    @Before
    public void init() {
        String addr = "jdbc:mysql://localhost/LOTTO";
        String user = "saru";
        String pw = "kke";

        lottoDB.saveConnectInfo(addr, user, pw);
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

        LottoLineDAO lottoLineDAO = LottoLineDAO.of();
        lottoLineDAO.clear();
        lottoLineDAO.insertLottoNums(lottoNums);
    }

    @Test
    public void insertLottoLines() {
        LottoMaker lottoMaker = LottoMaker.of();
        List<LottoLine> lottoLines = lottoMaker.makeAutoLottoLines(10);

        LottoLineDAO lottoLineDAO = LottoLineDAO.of();
        lottoLineDAO.clear();
        lottoLineDAO.insertLottoLines(lottoLines);
        System.out.println(lottoLines);
    }

    @Test
    public void getLottoLines() {
        LottoLineDAO lottoLineDAO = LottoLineDAO.of();

        LottoMaker lottoMaker = LottoMaker.of();
        List<LottoNum> lottoNums = lottoMaker.makeManualLottoNums("9,10,11,12,13,14");
        lottoLineDAO.insertLottoNums(lottoNums);

        List<LottoLine> lottoLines = lottoLineDAO.getLottoLines();
        System.out.println(lottoLines);
    }
}