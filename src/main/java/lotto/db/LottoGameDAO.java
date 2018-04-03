package lotto.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LottoGameDAO {
	Connection con = null;
	PreparedStatement pstmt = null;

	public int selectLatestTurnNo() throws SQLException {
		con = Common.getConnection();
		int turnNo = 0;
		ResultSet rs;
		try {
			pstmt = con.prepareStatement("select max(turn_no) from lotto_game");
			rs = pstmt.executeQuery();
			if (rs.next()) {
				turnNo = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("lotto_Game 테이블 select 실패");
		} finally {
			Common.close(pstmt, con);
		}
		if (turnNo == 0) {
			return 1;
		}
		return turnNo + 1;
	}

	public LottoGameDTO selectWinNo(String turnNo) throws SQLException {
		con = Common.getConnection();
		ResultSet rs;
		LottoGameDTO lottoGameDTO = null;
		try {
			pstmt = con.prepareStatement("select * from lotto_game where turn_no= ?");
			pstmt.setInt(1, Integer.parseInt(turnNo));
			rs = pstmt.executeQuery();
			while (rs.next()) {
				lottoGameDTO = new LottoGameDTO();
				lottoGameDTO.setTurnNo(rs.getInt("turn_no"));
				lottoGameDTO.setFirst(rs.getInt("win_first_no"));
				lottoGameDTO.setSecond(rs.getInt("win_second_no"));
				lottoGameDTO.setThird(rs.getInt("win_third_no"));
				lottoGameDTO.setFourth(rs.getInt("win_fourth_no"));
				lottoGameDTO.setFifth(rs.getInt("win_fifth_no"));
				lottoGameDTO.setSixth(rs.getInt("win_sixth_no"));
				lottoGameDTO.setBonus(rs.getInt("win_bonus_no"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("lotto_Game 테이블 select 실패");
		} finally {
			Common.close(pstmt, con);
		}
		return lottoGameDTO;
	}

	public void insertWinNo(String turnNo, LottoDTO lottoDTO) throws SQLException {
		con = Common.getConnection();
		String sql = "insert into lotto_game values(?,?,?,?,?,?,?,?)";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(turnNo));
			pstmt.setInt(2, lottoDTO.getNumber(0));
			pstmt.setInt(3, lottoDTO.getNumber(1));
			pstmt.setInt(4, lottoDTO.getNumber(2));
			pstmt.setInt(5, lottoDTO.getNumber(3));
			pstmt.setInt(6, lottoDTO.getNumber(4));
			pstmt.setInt(7, lottoDTO.getNumber(5));
			pstmt.setInt(8, lottoDTO.getNumber(6));
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("lotto_game 테이블 insert 실패");
		} finally {
			Common.close(pstmt, con);
		}
	}
	

	public void delete() throws SQLException {
		con = Common.getConnection();
		String sql = "delete from lotto_game";
		pstmt = con.prepareStatement(sql);
		Common.excuteUpdate(pstmt, con, "lotto_game 테이블 delete 실패");
	}

}
