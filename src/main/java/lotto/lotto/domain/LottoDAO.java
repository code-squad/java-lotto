package lotto.lotto.domain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class LottoDAO {

    private LottoDAO() {
    }

    public Connection getConnection() {
        String url = "jdbc:mysql://localhost:3306/lotto";
        String user = "root";
        String pw = "rlfls159";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection(url, user, pw);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public void insertLottos(List<Lotto> lottos) throws SQLException {
        String sql = "insert into LOTTOS(FIRST,SECOND,THIRD,FOURTH,FIFTH,SIXTH) values(?,?,?,?,?,?)";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = getConnection().prepareStatement(sql)) {
            for (Lotto lotto : lottos) {
                pstmt.setInt(1, lotto.getLotto().get(0));
                pstmt.setInt(2, lotto.getLotto().get(1));
                pstmt.setInt(3, lotto.getLotto().get(2));
                pstmt.setInt(4, lotto.getLotto().get(3));
                pstmt.setInt(5, lotto.getLotto().get(4));
                pstmt.setInt(6, lotto.getLotto().get(5));
                pstmt.executeUpdate();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void insertRank(Map<Rank, Integer> numberOfRank) throws SQLException {
        String sql = "insert into RANK(FIRST,SECOND,THIRD,FOURTH,FIFTH) values(?,?,?,?,?)";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = getConnection().prepareStatement(sql)) {
            pstmt.setInt(1, numberOfRank.get(Rank.FIRST));
            pstmt.setInt(2, numberOfRank.get(Rank.SECOND));
            pstmt.setInt(3, numberOfRank.get(Rank.THIRD));
            pstmt.setInt(4, numberOfRank.get(Rank.FOURTH));
            pstmt.setInt(5, numberOfRank.get(Rank.FIFTH));
            pstmt.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void deleteLottos() {
        String sql = "delete from lottos";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = getConnection().prepareStatement(sql)) {
            pstmt.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static class Singleton {
        private static final LottoDAO instance = new LottoDAO();
    }

    public static LottoDAO getInstance() {
        return Singleton.instance;
    }
}
