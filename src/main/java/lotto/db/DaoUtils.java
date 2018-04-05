package lotto.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DaoUtils {
	public static PreparedStatement makePrepareStatement(Connection con, String sql, String turnNo, int position)
			throws SQLException {
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(position, Integer.parseInt(turnNo));
		return pstmt;
	}
}
