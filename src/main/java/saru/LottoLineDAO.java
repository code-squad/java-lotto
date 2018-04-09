package saru;

import saru.domain.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LottoLineDAO {
    private LottoLineDAO() {
        // empty
    }

    public static LottoLineDAO of() {
        return new LottoLineDAO();
    }

    public void insertLottoNums(List<LottoNum> lottoNums) {
        LottoDB lottoDB = LottoDB.getInstance();
        try (Connection conn = lottoDB.createConnection()) {
            String sql = "INSERT INTO" +
                    " buyData(oneNum, twoNum, threeNum, fourNum, fiveNum, sixNum)" +
                    " VALUES(?, ?, ?, ?, ?, ?)";

            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setInt(1, lottoNums.get(0).getNum());
                pstmt.setInt(2, lottoNums.get(1).getNum());
                pstmt.setInt(3, lottoNums.get(2).getNum());
                pstmt.setInt(4, lottoNums.get(3).getNum());
                pstmt.setInt(5, lottoNums.get(4).getNum());
                pstmt.setInt(6, lottoNums.get(5).getNum());
                pstmt.execute();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertLottoLines(List<LottoLine> lottoLines) {
        for (LottoLine lottoLine : lottoLines) {
            insertLottoNums(lottoLine.getNumbers());
        }
    }

    public void clear() {
        LottoDB lottoDB = LottoDB.getInstance();
        try (Connection conn = lottoDB.createConnection()) {
            String sql = "DELETE FROM buyData";

            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.execute();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<LottoLine> getLottoLines() {
        LottoDB lottoDB = LottoDB.getInstance();
        try (Connection conn = lottoDB.createConnection()) {
            String sql = "SELECT oneNum,twoNum,threeNum,fourNum,fiveNum,sixNum FROM buyData";

            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                return resultSetToLottoLines(pstmt);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // TODO NULL
        return null;
    }

    private List<LottoLine> resultSetToLottoLines(PreparedStatement pstmt) {
        try (ResultSet resultSet = pstmt.executeQuery()) {
            List<LottoLine> lottoLines = new ArrayList<>();

            while (resultSet.next()) {
                List<LottoNum> lottoNums = new ArrayList<>();
                lottoNums.add(LottoNum.of(resultSet.getInt(1)));
                lottoNums.add(LottoNum.of(resultSet.getInt(2)));
                lottoNums.add(LottoNum.of(resultSet.getInt(3)));
                lottoNums.add(LottoNum.of(resultSet.getInt(4)));
                lottoNums.add(LottoNum.of(resultSet.getInt(5)));
                lottoNums.add(LottoNum.of(resultSet.getInt(6)));

                lottoLines.add(LottoLine.of(lottoNums));
            }

            return lottoLines;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // TODO NULL
        return null;
    }
}
