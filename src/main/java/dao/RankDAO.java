package dao;

import rank.Rank;
import result.Result;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class RankDAO {
    public void insert(Result result) throws SQLException {
        String sql = "insert into ranks (firstRank, secondRank, thirdRank, fourthRank, fifthRank) values (?,?,?,?,?)";
        PreparedStatement pstmt = LottoDAO.getConnection().prepareStatement(sql);
        pstmt.setInt(1, result.getFirst());
        pstmt.setInt(2, result.getSecond());
        pstmt.setInt(3, result.getThird());
        pstmt.setInt(4, result.getFourth());
        pstmt.setInt(5, result.getFifth());
        pstmt.executeUpdate();
    }
}
