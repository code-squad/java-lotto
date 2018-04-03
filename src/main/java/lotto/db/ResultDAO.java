package lotto.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ResultDAO {

	Connection con = null;
	PreparedStatement pstmt = null;

	public void insert(ResultDTO resultDTO) throws SQLException {
		con = Common.getConnection();
		String sql = "insert into result_lotto values(?,?,?,?,?,?)";
		pstmt = con.prepareStatement(sql);
		try {
			pstmt.setInt(1, resultDTO.getFirst());
			pstmt.setInt(2, resultDTO.getSecond());
			pstmt.setInt(3, resultDTO.getThird());
			pstmt.setInt(4, resultDTO.getFourth());
			pstmt.setInt(5, resultDTO.getFifth());
			pstmt.setInt(6, resultDTO.getRevenue());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("result_lotto 테이블 insert 실패");
		} finally {
			Common.close(pstmt, con);
		}
	}

	public ResultDTO select() throws SQLException {
		con = Common.getConnection();
		ResultDTO resultDTO = null;
		String sql = "select * from result_lotto";
		pstmt = con.prepareStatement(sql);
		ResultSet rs;
		try {
			rs = pstmt.executeQuery();
			while (rs.next()) {
				resultDTO = new ResultDTO();
				resultDTO.setFirst(rs.getInt("first_win"));
				resultDTO.setSecond(rs.getInt("second_win"));
				resultDTO.setThird(rs.getInt("third_win"));
				resultDTO.setFourth(rs.getInt("fourth_win"));
				resultDTO.setFifth(rs.getInt("fifth_win"));
				resultDTO.setRevenue(rs.getInt("revenue"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("result_lotto 테이블 select 실패");
		} finally {
			Common.close(pstmt, con);
		}
		return resultDTO;
	}

	public void delete() throws SQLException {
		con = Common.getConnection();
		String sql = "delete from result_lotto";
		pstmt = con.prepareStatement(sql);
		Common.excuteUpdate(pstmt, con, "result_lotto 테이블 delete 실패");
	}
}
