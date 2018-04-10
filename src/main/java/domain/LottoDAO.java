package domain;

import org.mozilla.javascript.EcmaError;
import util.Database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LottoDAO {
    private static LottoDAO lottoDAO = new LottoDAO();

    private LottoDAO() {

    }

    public static LottoDAO getInstance() {
        return lottoDAO;
    }

    public void insertResult(Map<Rank, Integer> result, int rate) {
        String sql = "insert into RESULT(FIRST, SECOND, THIRD, FOURTH, FIFTH, RATE) values (?,?,?,?,?,?)";
        try (PreparedStatement pstmt = Database.getConnection().prepareStatement(sql)) {
            int index = 1;
            for (Rank rank : Rank.values()) {
                pstmt.setInt(index, result.get(rank));
                index++;
            }
            pstmt.setInt(6, rate);
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void insertNo(List<LottoNo> numbers) {
        String sql = "insert into NUMBERS(NO1,NO2,NO3,NO4,NO5,NO6) values (?,?,?,?,?,?)";
        try (PreparedStatement pstmt = Database.getConnection().prepareStatement(sql)) {
            for (int i = 0; i < 6; i++) {
                LottoNo lottoNo = numbers.get(i);
                pstmt.setInt(i + 1, lottoNo.getLottoNo());
            }
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<String> selectNumbers(int count) {
        List<String> numbers = null;
        String sql = "select NO1, NO2, NO3, NO4, NO5, NO6 from " +
                "( select * from numbers order by UID desc limit ? ) " +
                "sub order by UID asc";
        try (PreparedStatement pstmt = Database.getConnection().prepareStatement(sql)) {
            StringBuilder sb = new StringBuilder();
            pstmt.setInt(1, count);
            ResultSet rs = pstmt.executeQuery();
            numbers = new ArrayList<>();

            while(rs.next()) {
                sb.setLength(0);
                sb.append(rs.getInt("NO1") + ", ");
                sb.append(rs.getInt("NO2") + ", ");
                sb.append(rs.getInt("NO3") + ", ");
                sb.append(rs.getInt("NO4") + ", ");
                sb.append(rs.getInt("NO5") + ", ");
                sb.append(rs.getInt("NO6"));
                numbers.add(sb.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return numbers;
    }
}
