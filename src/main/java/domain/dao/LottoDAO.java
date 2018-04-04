package domain.dao;

import domain.Lotto;
import domain.LottoBundle;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static utils.InputUtils.convertLottoNum;
import static utils.InputUtils.parseLottoNumbers;

public class LottoDAO {
    private static LottoDAO lottoDAO = new LottoDAO();
    private static final String TABLE_NAME = "buylotto";

    private LottoDAO() {
    }

    public static LottoDAO of() {
        return lottoDAO;
    }

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

    private void saveBuyLotto(String lottoNumber) {
        String sql = "INSERT INTO " + TABLE_NAME + " VALUES(?)";
        try (PreparedStatement statement = getConnection().prepareStatement(sql)) {
            statement.setString(1, lottoNumber);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public LottoBundle getBuyLottos() {
        String sql = "SELECT numbers FROM " + TABLE_NAME;
        LottoBundle lottoBundle = null;
        try (PreparedStatement statement = getConnection().prepareStatement(sql)){
            return convertLottoBundle(statement.executeQuery(sql));
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    private LottoBundle convertLottoBundle(ResultSet result) throws SQLException {
        LottoBundle lottoBundle = new LottoBundle();
        ArrayList<Lotto> lottos = new ArrayList<>();
        while (result.next()) {
            lottos.add(new Lotto(convertLottoNum(parseLottoNumbers(result.getString("numbers")))));
        }
        lottoBundle.addLotto(lottos);
        return lottoBundle;
    }

    public void deleteLottosRecord() {
        String sql = "DELETE FROM " + TABLE_NAME;
        try (PreparedStatement statement = getConnection().prepareStatement(sql)) {
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
