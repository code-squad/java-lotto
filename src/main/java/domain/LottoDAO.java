package domain;

import java.sql.*;
import java.util.List;

public class LottoDAO {

    public Connection getConnection() {
        String url = "jdbc:mysql://13.125.184.6:3306/lotto";
        String id = "colin";
        String password = "1234";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection(url, id, password);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public void saveBuyLottos(LottoBundle lottoBundle) {
        List<String> lottoNumbers = lottoBundle.getSavableLottoNumbers();
        for (String lottoNumber : lottoNumbers) {
            saveBuyLotto(lottoNumber);
        }
    }

    public void saveBuyLotto(String lottoNumber) {
        String sql = "insert into buylotto values(?,?,?)";
        PreparedStatement statement = null;
        try {
            statement = getConnection().prepareStatement(sql);
            statement.setInt(1, 0);
            statement.setString(2, lottoNumber);
            statement.setDate(3, null);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    //번호들을 찾아와서 어떤 작업들을 해서 로또로 만들고 리스트에 추가해서 로또 번들 생성하고 리턴해줘야지
    public LottoBundle getBuyLottos(String lottoNumber) {
        String sql = "select numbers from buylotto";
        PreparedStatement statement = null;
        try {
            statement = getConnection().prepareStatement(sql);
            ResultSet result = statement.executeQuery(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
