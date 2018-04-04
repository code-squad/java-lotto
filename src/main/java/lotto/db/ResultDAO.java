package lotto.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ResultDAO {

	public void insert(ResultDTO resultDTO, String turnNo) throws SQLException {
		String sql = "insert into result_lotto values(?,?,?,?,?,?,?)";
		try (Connection con = DBconnector.getInstance().getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {
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
		}
	}

	public ResultDTO select() throws SQLException {
		ResultDTO resultDTO = null;
		try (Connection con = DBconnector.getInstance().getConnection();
				PreparedStatement pstmt = con.prepareStatement("select * from result_lotto");
				ResultSet rs = pstmt.executeQuery()) {
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
		}
		return resultDTO;
	}

	public ResultDTO select(String inputTurnNo) throws SQLException {
		ResultDTO resultDTO = null;
		try (Connection con = DBconnector.getInstance().getConnection();
				PreparedStatement pstmt = DaoUtils.makePrepareStatement(con,
						"select * from result_lotto where turn_no = ?", inputTurnNo, 1);
				ResultSet rs = pstmt.executeQuery()) {
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
		}
		return resultDTO;
	}

	public void delete() throws SQLException {
		String sql = "delete from result_lotto";
		try (Connection con = DBconnector.getInstance().getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);) {
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("result_lotto 테이블 delete 실패");
		}
	}
}
