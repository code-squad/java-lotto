import lotto.Lotto;

import java.sql.Connection;
import java.sql.*;

public class LottoDAO {
    public Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Lotto", "root", "12345");
            System.out.println("연결성공" + conn);
            return conn;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            System.out.println("연결실패");
            return null;
        }
    }

    public void insert(Lotto lotto) throws SQLException {
        String sql = "insert into lottos (firstNumber, secondNumber, thirdNumber, fourthNumber, fifthNumber, sixthNumber) values(?,?,?,?,?,?)";
        PreparedStatement pstmt = getConnection().prepareStatement(sql);
        pstmt.setInt(1, lotto.getLotto().get(0));
        pstmt.setInt(2, lotto.getLotto().get(1));
        pstmt.setInt(3, lotto.getLotto().get(2));
        pstmt.setInt(4, lotto.getLotto().get(3));
        pstmt.setInt(5, lotto.getLotto().get(4));
        pstmt.setInt(6, lotto.getLotto().get(5));
        pstmt.executeUpdate();
    }
}
