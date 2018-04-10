package dao;

import result.Result;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import static dao.LottoDAO.getConnection;

public class RankDAO {
    public void insert(Result result) throws SQLException {
        String sql = "insert into ranks (firstRank, secondRank, thirdRank, fourthRank, fifthRank) values (?,?,?,?,?)";
        PreparedStatement pstmt = getConnection().prepareStatement(sql);
        pstmt.setInt(1, result.getFirst());
        pstmt.setInt(2, result.getSecond());
        pstmt.setInt(3, result.getThird());
        pstmt.setInt(4, result.getFourth());
        pstmt.setInt(5, result.getFifth());
        pstmt.executeUpdate();
    }
}
