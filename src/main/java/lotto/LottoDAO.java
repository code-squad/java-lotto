package lotto;

import lotto.domain.Lotto;
import lotto.domain.Match;
import lotto.domain.Results;

import java.sql.*;
import java.util.List;

public class LottoDAO {
    private final String userLottoTable = "user_lotto";
    private final String resultTable = "result";

    public Connection getConnection() {
        String url = "jdbc:mysql://192.168.56.101:3306/lotto";
        String id = "krapeaj";
        String password = "krapeaj";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection(url, id, password);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public void addToUserLotto(Lotto lotto) {
        try {
            String sql = "INSERT INTO " + userLottoTable + "(first,second,third,fourth,fifth,sixth) values(?,?,?,?,?,?)";
            PreparedStatement pstmt = getConnection().prepareStatement(sql);

            int ticketCount = lotto.getNumberOfTickets();
            for (int i = 0; i < ticketCount; i++) {
                List<Integer> numbers = lotto.getNumbers(i);
                pstmt.setInt(1, numbers.get(0));
                pstmt.setInt(2, numbers.get(1));
                pstmt.setInt(3, numbers.get(2));
                pstmt.setInt(4, numbers.get(3));
                pstmt.setInt(5, numbers.get(4));
                pstmt.setInt(6, numbers.get(5));

                pstmt.execute();
            }
            pstmt.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void renewUserLottoTable() {
        try {
            Statement stmt = getConnection().createStatement();

            String sql = "DROP TABLE IF EXISTS " + userLottoTable;
            stmt.executeUpdate(sql);

            sql = "CREATE TABLE " + userLottoTable +
                    "(count TINYINT PRIMARY KEY AUTO_INCREMENT," +
                    "first TINYINT NOT NULL," +
                    "second TINYINT NOT NULL," +
                    "third TINYINT NOT NULL," +
                    "fourth TINYINT NOT NULL," +
                    "fifth TINYINT NOT NULL," +
                    "sixth TINYINT NOT NULL" +
                    ");";
            stmt.executeUpdate(sql);

            stmt.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void renewResultTable() {
        try {
            Statement stmt = getConnection().createStatement();

            String sql = "DROP TABLE IF EXISTS " + resultTable;
            stmt.executeUpdate(sql);

            sql = "CREATE TABLE " + resultTable +
                    "(rank CHAR(16) NOT NULL," +
                    "count TINYINT DEFAULT 0);";
            stmt.executeUpdate(sql);

            stmt.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void addToResult(Results results) {
        try {
            String sql = "INSERT INTO " + resultTable + " VALUES(?,?);";
            PreparedStatement pstmt = getConnection().prepareStatement(sql);

            for (Match rank : Match.values()) {
                pstmt.setString(1, rank.identify(rank));
                pstmt.setInt(2, results.getCount(rank));
                pstmt.execute();
            }

            pstmt.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}