package domain;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static domain.LottoUtils.inputParser;

public class LottoDAO {

    public Connection getConnection() {
        String addr="jdbc:mysql://localhost:3306/lottodb";
        String user="larryjung";
        String pw="db1004";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection(addr, user, pw);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public void insertUserInfo(User user) throws SQLException {
        // add user information into USERS table
        String sql = "insert into USERS values(?,?)";
        PreparedStatement preparedStatement = getConnection().prepareStatement(sql);
        preparedStatement.setString(1, user.getName());
        List<Integer> initPrize = Arrays.asList(0, 0, 0, 0, 0);
        preparedStatement.setString(2, initPrize.toString());
        preparedStatement.executeUpdate();

        // add lotto numbers information of user into LOTTO table
        String sql2 = "insert into LOTTOS values(?,?)";
        preparedStatement = getConnection().prepareStatement(sql2);
        for (Lotto lotto : user.getLottos()) {
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, lotto.toString());
            preparedStatement.executeUpdate();
        }
        preparedStatement.close();

    }

    public void insertWinningLotto(LotteryCommission lotteryCommission) throws SQLException {
        // add user information into USERS table
        String sql = "insert into WINNINGLOTTOS values(?,?,?)";
        PreparedStatement preparedStatement = getConnection().prepareStatement(sql);
        preparedStatement.setInt(1, lotteryCommission.getRound());
        preparedStatement.setString(2, lotteryCommission.getWinningLotto().toString());
        preparedStatement.setString(3, lotteryCommission.getWinningLotto().getBonusNum().toString());
        preparedStatement.executeUpdate();
        preparedStatement.close();

    }

    public void updateUserInfo(User user) throws SQLException {
        // update user's prize statistics
        String sql = "update USERS set prizelist = ? where name = ?";
        PreparedStatement preparedStatement = getConnection().prepareStatement(sql);
        preparedStatement.setString(2, user.getName());
        preparedStatement.setString(1, user.getPrizeStatistics().toString());
        preparedStatement.executeUpdate();
        }

    public User findResultByUserName(String userName) throws SQLException {
        String sql = "SELECT * FROM USERS where name = ?";
        PreparedStatement preparedStatement = getConnection().prepareStatement(sql);
        preparedStatement.setString(1, userName);

        ResultSet rs = preparedStatement.executeQuery();
        if (rs.next()) {
            User user = User.nameOf(rs.getString("userId"));
            user.setPrizeStatistics((List<Integer>) rs.getArray("prizelist"));
            return user;
        }
        preparedStatement.close();
        return null;
    }

    public List<LottoNoGroup> findLottoNumbersByUserName(String userName) throws SQLException {
        List<LottoNoGroup> lottoNoGroups = new ArrayList<>();
        String sql = "SELECT * FROM LOTTOS where name = ?";
        PreparedStatement preparedStatement = getConnection().prepareStatement(sql);
        preparedStatement.setString(1, userName);
        ResultSet rs = preparedStatement.executeQuery();
        while (rs.next()) {
            lottoNoGroups.add(inputParser(rs.getString("lottoNo")));
        }
        preparedStatement.close();
        return lottoNoGroups;
    }

}
