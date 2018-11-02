package dao;

import dto.LottoDto;
import dto.LottosDto;
import util.Parser;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LottoDao extends AbstractDao {

    public void insert(LottoDto lottoDto) throws SQLException {
        String sql = "insert into lotto values(?)";
        PreparedStatement pstm = getConnection().prepareStatement(sql);

        pstm.setString(1, lottoDto.toString());
        pstm.executeUpdate();
    }


    public void insertAll(LottosDto lottosDto) {
        lottosDto.getLottoDtos().stream().forEach(lottoDto -> {
            try {
                insert(lottoDto);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
    }

    public int count() throws SQLException {
        String sql = "select count(*) from lotto";
        PreparedStatement pstm = getConnection().prepareStatement(sql);

        ResultSet rs = pstm.executeQuery();
        if (rs.next()) {
            return rs.getInt(1);
        }
        return 0;
    }

    public void clear() throws SQLException {
        String sql = "delete from lotto";
        PreparedStatement pstm = getConnection().prepareStatement(sql);

        pstm.executeUpdate();
    }

    public LottosDto selectAll() throws SQLException {
        List<LottoDto> lottosDto = new ArrayList<>();
        String sql = "select * from lotto";
        PreparedStatement pstm = getConnection().prepareStatement(sql);

        ResultSet rs = pstm.executeQuery();
        while (rs.next()) {
            lottosDto.add(Parser.parseDbRow(rs.getString(1)));
        }

        return LottosDto.init(lottosDto);
    }

}
