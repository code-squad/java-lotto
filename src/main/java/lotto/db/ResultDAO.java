package lotto.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ResultDAO {

	Connection con = null;
	PreparedStatement pstmt = null;

	public void insert(ResultDTO resultDTO, String turnNo) throws SQLException {
		con = Common.getConnection();
		String sql = "insert into result_lotto values(?,?,?,?,?,?,?)";
		pstmt = con.prepareStatement(sql);
		try {
			pstmt.setInt(1, Integer.parseInt(turnNo));
			pstmt.setInt(2, resultDTO.getFirst());
			pstmt.setInt(3, resultDTO.getSecond());
			pstmt.setInt(4, resultDTO.getThird());
			pstmt.setInt(5, resultDTO.getFourth());
			pstmt.setInt(6, resultDTO.getFifth());
			pstmt.setInt(7, resultDTO.getRevenue());
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
		pstmt = con.prepareStatement("select * from result_lotto");
		ResultSet rs;
		try {
			rs = pstmt.executeQuery();
			while (rs.next()) {
				resultDTO = new ResultDTO();
				resultDTO.setTurnNo(rs.getInt("turn_no"));
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
	public ResultDTO select(String inputTurnNo) throws SQLException {
		con = Common.getConnection();
		ResultDTO resultDTO = null;
		pstmt = con.prepareStatement("select * from result_lotto where turn_no = ?");
		pstmt.setInt(1, Integer.parseInt(inputTurnNo));
		ResultSet rs;
		try {
			rs = pstmt.executeQuery();
			while (rs.next()) {
				resultDTO = new ResultDTO();
				resultDTO.setTurnNo(rs.getInt("turn_no"));
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
