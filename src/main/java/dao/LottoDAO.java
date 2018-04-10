package dao;

import lotto.Lotto;
import java.sql.Connection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LottoDAO {
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

    public void insert(Lotto lotto) {
        String sql = "insert into lottos values(?,?,?,?,?,?)";
        try (PreparedStatement pstmt = getConnection().prepareStatement(sql)) {
            pstmt.setInt(1, lotto.getLotto().get(0));
            pstmt.setInt(2, lotto.getLotto().get(1));
            pstmt.setInt(3, lotto.getLotto().get(2));
            pstmt.setInt(4, lotto.getLotto().get(3));
            pstmt.setInt(5, lotto.getLotto().get(4));
            pstmt.setInt(6, lotto.getLotto().get(5));
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public void lottosInserting(List<Lotto> lottos) {
        for(Lotto lotto : lottos)
            insert(lotto);
    }

    public List<Lotto> readLottos() {
        String sql = "select * from lottos";
        List<Lotto> lottos = new ArrayList<>();
        try (PreparedStatement pstmp = getConnection().prepareStatement(sql)) {
            try (ResultSet rs = pstmp.executeQuery()){
                while (rs.next()) {
                    String strNumber = rs.getString("firstNumber") + "," + rs.getString("secondNumber") + "," +rs.getString("thirdNumber") + "," + rs.getString("fourthNumber") + "," +rs.getString("fifthNumber") + "," + rs.getString("sixthNumber");
                    Lotto lotto = new Lotto(strNumber);
                    System.out.println(lotto.getLotto());
                    lottos.add(lotto);
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        return lottos;
    }
}
