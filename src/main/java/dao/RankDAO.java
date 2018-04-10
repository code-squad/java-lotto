package dao;

import rank.Rank;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class RankDAO {
    public void insert(Rank rank) throws SQLException {
        String sql = "insert into ranks values (?,?,?,?,?,?)";
        PreparedStatement pstmt = LottoDAO.getConnection().prepareStatement(sql);
        }
    }
}
