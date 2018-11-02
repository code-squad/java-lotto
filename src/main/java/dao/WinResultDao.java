package dao;

import dto.WinResultDto;
import vo.Rank;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class WinResultDao extends AbstractDao {

    public void insertAll(WinResultDto winResultDto) throws SQLException {
        Map<Rank, Integer> winResult = winResultDto.getWinResultDto();
        for (Rank rank : winResult.keySet()) {
            insert(rank, winResult.get(rank));
        }
    }

    public void insert(Rank rank, int amt) throws SQLException {
        String sql = "insert into win_result values(?,?)";
        PreparedStatement pstm = getConnection().prepareStatement(sql);
        pstm.setString(1, rank.toString());
        pstm.setInt(2, amt);

        pstm.executeUpdate();
    }


    public void clear() throws SQLException {
        String sql = "delete from win_result";
        PreparedStatement pstm = getConnection().prepareStatement(sql);

        pstm.executeUpdate();
    }

    public WinResultDto selectAll() throws SQLException {
        Map<Rank, Integer> winResultDto = new HashMap<>();
        String sql = "select * from win_result";
        PreparedStatement pstm = getConnection().prepareStatement(sql);

        ResultSet rs = pstm.executeQuery();
        while (rs.next()) {
            winResultDto.put(Rank.valueOf(rs.getString(1)),
                    rs.getInt(2));
        }

        return WinResultDto.initArtifitial(winResultDto);
    }

}
