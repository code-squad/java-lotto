package lotto.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LottoDAO {

	Connection con = null;
	PreparedStatement pstmt = null;

	public void insert(LottoDTO lottoDTO) throws SQLException {
		con = Common.getConnection();
		String sql = "insert into user_lotto values(NULL,?,?,?,?,?,?)";
		pstmt = con.prepareStatement(sql);
		try {
			pstmt.setInt(1, lottoDTO.getNumbers().get(0));
			pstmt.setInt(2, lottoDTO.getNumbers().get(1));
			pstmt.setInt(3, lottoDTO.getNumbers().get(2));
			pstmt.setInt(4, lottoDTO.getNumbers().get(3));
			pstmt.setInt(5, lottoDTO.getNumbers().get(4));
			pstmt.setInt(6, lottoDTO.getNumbers().get(5));
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("user_lotto 테이블 insert 실패");
		} finally {
			Common.close(pstmt, con);
		}
	}

	public List<LottoDTO> select() throws SQLException {
		con = Common.getConnection();
		List<LottoDTO> lottos = new ArrayList<>();
		String sql = "select * from user_lotto";
		pstmt = con.prepareStatement(sql);
		ResultSet rs;
		try {
			rs = pstmt.executeQuery();
			while (rs.next()) {
				List<Integer> temp = Arrays.asList(rs.getInt("first_no"), rs.getInt("second_no"), rs.getInt("third_no"),
						rs.getInt("fourth_no"), rs.getInt("fifth_no"), rs.getInt("sixth_no"));
				LottoDTO lottoDTO = new LottoDTO();
				lottoDTO.setNumbers(temp);
				lottos.add(lottoDTO);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("user_lotto 테이블 insert 실패");
		} finally {
			Common.close(pstmt, con);
		}
		return lottos;
	}

	public void delete() throws SQLException {
		con = Common.getConnection();
		String sql = "delete from user_lotto";
		pstmt = con.prepareStatement(sql);
		Common.excuteUpdate(pstmt, con, "user_lotto 테이블 delete 실패");
	}

	public void init() throws SQLException {
		con = Common.getConnection();
		String sql = "alter table user_lotto auto_increment = 1";
		pstmt = con.prepareStatement(sql);
		Common.excuteUpdate(pstmt, con, "user_lotto 테이블 init 실패");
	}

}
