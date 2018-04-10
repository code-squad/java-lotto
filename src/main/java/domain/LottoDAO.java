package domain;

import Util.Database;

import java.sql.PreparedStatement;
import java.util.List;
import java.util.Map;

public class LottoDAO {
    public void insertResult(Map<Rank, Integer> result, int rate) throws Exception {
        String sql = "insert into RESULT(FIRST, SECOND, THIRD, FOURTH, FIFTH, RATE) values (?,?,?,?,?,?)";
        PreparedStatement pstmt = Database.getConnection().prepareStatement(sql);
        //각 랭크의 회수를 저장하려고 하는 중.
        int index = 1;
        for (Rank rank : Rank.values()) {
            pstmt.setInt(index, result.get(rank));
            index++;
        }
        pstmt.setInt(6, rate);
        pstmt.executeUpdate();
    }

    public void insertNo(List<LottoNo> numbers) throws Exception {
        String sql = "insert into NUMBERS(NO1,NO2,NO3,NO4,NO5,NO6) values (?,?,?,?,?,?)";
        PreparedStatement pstmt = Database.getConnection().prepareStatement(sql);
        for (int i = 0; i < 6; i++) {
            LottoNo lottoNo = numbers.get(i);
            pstmt.setInt(i + 1, lottoNo.getLottoNo());
        }
        pstmt.executeUpdate();
    }
}
