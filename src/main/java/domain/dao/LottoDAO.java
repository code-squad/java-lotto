package domain.dao;

import domain.Lotto;
import domain.LottoBundle;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static utils.InputUtils.convertLottoNum;
import static utils.InputUtils.parseLottoNumbers;

public class LottoDAO extends DAO {
    private static LottoDAO lottoDAO = new LottoDAO();
    private static final String TABLE_NAME = "buylotto";

    private LottoDAO() {
    }

    public static LottoDAO of() {
        return lottoDAO;
    }

    public void saveBuyLottos(LottoBundle lottoBundle) {
        List<String> lottoNumbers = lottoBundle.getSavableLottoNumbers();
        for (String lottoNumber : lottoNumbers) {
            saveBuyLotto(lottoNumber);
        }
    }

    private void saveBuyLotto(String lottoNumber) {
        String sql = "insert into " + TABLE_NAME + " values(?)";
        PreparedStatement statement = null;
        try {
            statement = getConnection().prepareStatement(sql);
            statement.setString(1, lottoNumber);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public LottoBundle getBuyLottos() {
        String sql = "select numbers from " + TABLE_NAME;
        PreparedStatement statement = null;
        try {
            statement = getConnection().prepareStatement(sql);
            return convertLottoBundle(statement.executeQuery(sql));
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
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
        String sql = "delete from " + TABLE_NAME;
        PreparedStatement statement = null;
        try {
            statement = getConnection().prepareStatement(sql);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
