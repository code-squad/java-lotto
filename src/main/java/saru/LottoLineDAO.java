package saru;

import saru.domain.*;

import java.sql.*;
import java.util.*;

public class LottoLineDAO {
    private LottoLineDAO() {
        // empty
    }

    public static LottoLineDAO of() {
        return new LottoLineDAO();
    }

    void insertLottoNums(List<LottoNum> lottoNums) {
        LottoDB lottoDB = LottoDB.getInstance();
        try (Connection conn = lottoDB.createConnection()) {
            String sql = "INSERT INTO" +
                    " buyData(oneNum, twoNum, threeNum, fourNum, fiveNum, sixNum)" +
                    " VALUES(?, ?, ?, ?, ?, ?)";

            excuteSQL(lottoNums, conn, sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void excuteSQL(List<LottoNum> lottoNums, Connection conn, String sql) {
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            prepareSetProc(lottoNums, pstmt);
            pstmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void prepareSetProc(List<LottoNum> lottoNums, PreparedStatement pstmt) throws SQLException {
        pstmt.setInt(1, lottoNums.get(0).getNum());
        pstmt.setInt(2, lottoNums.get(1).getNum());
        pstmt.setInt(3, lottoNums.get(2).getNum());
        pstmt.setInt(4, lottoNums.get(3).getNum());
        pstmt.setInt(5, lottoNums.get(4).getNum());
        pstmt.setInt(6, lottoNums.get(5).getNum());
    }

    void insertLottoLines(List<LottoLine> lottoLines) {
        clear();

        for (LottoLine lottoLine : lottoLines) {
            insertLottoNums(lottoLine.getNumbers());
        }
    }

    void clear() {
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

    List<LottoLine> getLottoLines() {
        LottoDB lottoDB = LottoDB.getInstance();
        try (Connection conn = lottoDB.createConnection()) {
            String sql = "SELECT oneNum,twoNum,threeNum,fourNum,fiveNum,sixNum FROM buyData";

            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                return resultSetToLottoLines(pstmt);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return new ArrayList<>();
    }

    List<LottoLine> resultSetToLottoLines(PreparedStatement pstmt) {
        try (ResultSet resultSet = pstmt.executeQuery()) {
            List<LottoLine> lottoLines = new ArrayList<>();

            resultSetToLottoLines(resultSet, lottoLines);

            return lottoLines;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return new ArrayList<>();
    }

    private void resultSetToLottoLines(ResultSet resultSet, List<LottoLine> lottoLines) throws SQLException {
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
    }
}
