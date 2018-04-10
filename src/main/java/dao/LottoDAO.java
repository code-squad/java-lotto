package dao;

import lotto.Lotto;
import java.sql.Connection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LottoDAO {
    private List<Lotto> lottos;

    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Lotto", "root", "12345");
            return conn;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    public void insert(Lotto lotto) throws SQLException {
        String sql = "insert into lottos values(?,?,?,?,?,?)";
        PreparedStatement pstmt = getConnection().prepareStatement(sql);
        pstmt.setInt(1, lotto.getLotto().get(0));
        pstmt.setInt(2, lotto.getLotto().get(1));
        pstmt.setInt(3, lotto.getLotto().get(2));
        pstmt.setInt(4, lotto.getLotto().get(3));
        pstmt.setInt(5, lotto.getLotto().get(4));
        pstmt.setInt(6, lotto.getLotto().get(5));
        pstmt.executeUpdate();
    }

    public void lottosInserting(List<Lotto> lottos) throws SQLException {
        for(Lotto lotto : lottos)
            insert(lotto);
    }

    public List<Lotto> readLottos() throws SQLException {
        String sql = "select * from lottos";
        PreparedStatement pstmp = getConnection().prepareStatement(sql);
        ResultSet rs = pstmp.executeQuery();
        lottos = new ArrayList<>();
        while (rs.next()) {
            String strNumber = rs.getString("firstNumber") + "," + rs.getString("secondNumber") + "," +rs.getString("thirdNumber") + "," + rs.getString("fourthNumber") + "," +rs.getString("fifthNumber") + "," + rs.getString("sixthNumber");
            Lotto lotto = new Lotto(strNumber);
            System.out.println(lotto.getLotto());
            lottos.add(lotto);
        }
        return lottos;
    }
}
