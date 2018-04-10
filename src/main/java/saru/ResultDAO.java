package saru;

import java.sql.*;

public class ResultDAO {
    private static ResultDAO resultDAO = new ResultDAO();

    private ResultDAO() {
        // empty
    }

    public static ResultDAO getInstance() {
        return resultDAO;
    }

    void insertResult(Result result) {
        LottoDB lottoDB = LottoDB.getInstance();
        try (Connection conn = lottoDB.createConnection()) {
            String sql = "INSERT INTO" +
                    " winning(first, second, third, fourth, fifth, income)" +
                    " VALUES(?, ?, ?, ?, ?, ?)";

            executeSQL(result, conn, sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void executeSQL(Result result, Connection conn, String sql) {
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            prepareSetProc(result, pstmt);
            pstmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void prepareSetProc(Result result, PreparedStatement pstmt) throws SQLException {
        pstmt.setInt(1, result.getMatchNum_first());
        pstmt.setInt(2, result.getMatchNum_second());
        pstmt.setInt(3, result.getMatchNum_third());
        pstmt.setInt(4, result.getMatchNum_fourth());
        pstmt.setInt(5, result.getMatchNum_fifth());
        pstmt.setInt(6, result.getCalcIncome());
    }
}
