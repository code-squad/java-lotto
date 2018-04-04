package lotto.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LottoDAO {

	public void insert(String turnNo, LottoDTO lottoDTO) throws SQLException {
		String sql = "insert into user_lotto values(?,?,?,?,?,?,?)";
		try (Connection con = DBconnector.getInstance().getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setInt(1, Integer.parseInt(turnNo));
			pstmt.setInt(2, lottoDTO.getNumber(0));
			pstmt.setInt(3, lottoDTO.getNumber(1));
			pstmt.setInt(4, lottoDTO.getNumber(2));
			pstmt.setInt(5, lottoDTO.getNumber(3));
			pstmt.setInt(6, lottoDTO.getNumber(4));
			pstmt.setInt(7, lottoDTO.getNumber(5));
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("user_lotto 테이블 insert 실패");
		}

	}

	public List<LottoDTO> select(String turnNo) throws SQLException {
		List<LottoDTO> lottos = new ArrayList<>();

		try (Connection con = DBconnector.getInstance().getConnection();
				PreparedStatement pstmt = DaoUtils.makePrepareStatement(con, "select * from user_lotto where turn_no = ?", turnNo, 1);
				ResultSet rs = pstmt.executeQuery()) {
			while (rs.next()) {
				List<Integer> temp = Arrays.asList(rs.getInt("first_no"), rs.getInt("second_no"), rs.getInt("third_no"),
						rs.getInt("fourth_no"), rs.getInt("fifth_no"), rs.getInt("sixth_no"));
				LottoDTO lottoDTO = new LottoDTO();
				lottoDTO.setNumbers(temp);
				lottos.add(lottoDTO);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("user_lotto 테이블 select 실패");
		}
		return lottos;
	}
	

	public void delete() throws SQLException {
		try (Connection con = DBconnector.getInstance().getConnection();
				PreparedStatement pstmt = con.prepareStatement("delete from user_lotto")) {
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("user_lotto 테이블 delete 실패");
		}

	}

}
