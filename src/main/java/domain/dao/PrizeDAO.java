package domain.dao;

import domain.result.LottoResults;
import domain.result.Rank;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PrizeDAO {
    private static PrizeDAO prizeDAO = new PrizeDAO();
    private static final String TABLE_NAME = "prize";

    private PrizeDAO() {

    }

    public Connection getConnection() {
        String url = "jdbc:mysql://13.125.184.6:3306/lotto";
        String id = "colin";
        String password = "1234";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection(url, id, password);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public static PrizeDAO of() {
        return prizeDAO;
    }

    public void savePrize(LottoResults results) {
        for (Rank rank : Rank.values()) {
            savePrizeInfo(rank.getMatchPoint(), results.calcRankNum(rank));
        }
    }

    public void savePrizeInfo(int matchPoint, int rankCount) {
        String sql = "INSERT INTO " + TABLE_NAME + " VALUES(?,?,?)";
        try (PreparedStatement statement = getConnection().prepareStatement(sql)) {
            statement.setInt(1, matchPoint);
            statement.setInt(2, rankCount);
            statement.setDate(3, null);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
