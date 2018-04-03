package domain.dao;

import domain.result.LottoResults;
import domain.result.Rank;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PrizeDAO extends DAO {
    private static PrizeDAO prizeDAO = new PrizeDAO();
    private static final String TABLE_NAME = "prize";

    private PrizeDAO() {

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
        String sql = "insert into " + TABLE_NAME + " values(?,?,?)";
        PreparedStatement statement = null;
        try {
            statement = getConnection().prepareStatement(sql);
            statement.setDate(1, null);
            statement.setInt(2, matchPoint);
            statement.setInt(3, rankCount);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
