package domain;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static domain.LottoUtils.TICKET_PRICE;
import static domain.LottoUtils.inputParser;

public class LottoDAO {

    public Connection getConnection() {
        String addr = "jdbc:mysql://localhost:3306/lottodb";
        String user = "larryjung";
        String pw = "db1004";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection(addr, user, pw);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public void insertUserInfo(User user, String round, String inputMoney) throws SQLException {
        // add user information into USERS table
        String sql = "insert into USERS values(?,?,?,?)";
        PreparedStatement preparedStatement = getConnection().prepareStatement(sql);
        preparedStatement.setInt(1, Integer.parseInt(round));
        preparedStatement.setString(2, user.getName());
        preparedStatement.setInt(3, Integer.parseInt(inputMoney));
        List<Integer> initPrize = Arrays.asList(0, 0, 0, 0, 0);
        preparedStatement.setString(4, initPrize.toString());
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }

    public void insertLottosInfo(User user, String round, String inputMoney) throws SQLException {
        // add lotto numbers information of user into LOTTO table
        String sql = "insert into LOTTOS values(?,?,?)";
        PreparedStatement preparedStatement = getConnection().prepareStatement(sql);
        for (Lotto lotto : user.getLottos()) {
            preparedStatement.setString(1, round);
            preparedStatement.setString(2, user.getName());
            preparedStatement.setString(3, lotto.toString().replaceAll("[\\[\\]\"]", ""));
            preparedStatement.executeUpdate();
        }
        preparedStatement.close();
    }

    public void removeUserInfo(User user, String round) throws SQLException {
        String sql = "DELETE FROM users WHERE name = ? AND round = ?";
        PreparedStatement preparedStatement = getConnection().prepareStatement(sql);
        preparedStatement.setString(1, user.getName());
        preparedStatement.setInt(2, Integer.parseInt(round));
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }

    public void removeLottosInfo(User user, String round) throws SQLException {
        String sql = "DELETE FROM lottos WHERE name = ? AND round = ?";
        PreparedStatement preparedStatement = getConnection().prepareStatement(sql);
        preparedStatement.setString(1, user.getName());
        preparedStatement.setInt(2, Integer.parseInt(round));
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }

    public void insertWinningLotto(String round, String winningNumber, String bonusNumber) throws SQLException {
        // add user information into USERS table
        String sql = "insert into WINNINGLOTTOS values(?,?,?)";
        PreparedStatement preparedStatement = getConnection().prepareStatement(sql);
        preparedStatement.setInt(1, Integer.parseInt(round));
        preparedStatement.setString(2, winningNumber.replaceAll("[\\[\\]\"]", ""));
        preparedStatement.setInt(3, Integer.parseInt(bonusNumber));
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }

    public void removeWinningLotto(String round) throws SQLException {
        String sql = "DELETE FROM winningLottos WHERE round = ?";
        PreparedStatement preparedStatement = getConnection().prepareStatement(sql);
        preparedStatement.setInt(1, Integer.parseInt(round));
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }


    public void updateUserInfo(User user, String round) throws SQLException {
        // update user's prize statistics
        String sql = "update USERS set prizelist = ? where name = ? AND round = ?";
        PreparedStatement preparedStatement = getConnection().prepareStatement(sql);
        preparedStatement.setString(2, user.getName());
        preparedStatement.setString(3, user.getName());
        preparedStatement.setString(1, user.getPrizeStatistics().toString());
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }

    public LotteryCommission findWinningNumberByRound(String round) throws SQLException {
        String sql = "SELECT * FROM WINNINGLOTTOS where round = ?";
        PreparedStatement preparedStatement = getConnection().prepareStatement(sql);
        preparedStatement.setInt(1, Integer.parseInt(round));

        ResultSet rs = preparedStatement.executeQuery();
        if (rs.next()) {
            LotteryCommission lotteryCommission = new LotteryCommission(rs.getInt("round"));
            lotteryCommission.selectWinningNumbers(inputParser(rs.getString("lottoNo")),
                    LottoNo.of(rs.getInt("bonusNo")));
            return lotteryCommission;
        }
        preparedStatement.close();
        return null;
    }

    private List<LottoNoGroup> takeLottoNos(String userName, String round) throws SQLException {
        String sql = "SELECT * FROM LOTTOS where name = ? AND round = ?";
        PreparedStatement preparedStatement = getConnection().prepareStatement(sql);
        preparedStatement.setString(1, userName);
        preparedStatement.setInt(2, Integer.parseInt(round));
        ResultSet rs = preparedStatement.executeQuery();
        List<LottoNoGroup> lottoNoGroups = new ArrayList<>();
        while (rs.next()) {
            lottoNoGroups.add(inputParser(rs.getString("lottoNo")));
        }
        preparedStatement.close();
        return lottoNoGroups;
    }

    private int takeInputMoney(String userName, String round) throws SQLException {
        String sql = "SELECT * FROM USERS where name = ? AND round = ?";
        PreparedStatement preparedStatement = getConnection().prepareStatement(sql);
        preparedStatement.setString(1, userName);
        preparedStatement.setInt(2, Integer.parseInt(round));
        ResultSet rs = preparedStatement.executeQuery();
        int inputMoney = 0;
        if (rs.next()) {
            return Integer.parseInt(rs.getString("inputMoney"));
        }
        preparedStatement.close();
        return inputMoney;
    }

    public User findLottoNumbersByUserNameAndRoundFromUsers(String userName, String round) throws SQLException {
        User user = User.nameOf(userName);
        user.hasMoneyOf(takeInputMoney(userName, round));
        return user;
    }

    public User findLottoNumbersByUserNameAndRoundFromLottos(String userName, String round) throws SQLException {
        User user = User.nameOf(userName);
        List<LottoNoGroup> lottoNoGroups = takeLottoNos(userName, round);
        user.hasMoneyOf(lottoNoGroups.size() * TICKET_PRICE);
        user.purchaseTicketsManual(lottoNoGroups);
        return user;
    }


}
