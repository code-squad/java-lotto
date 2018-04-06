package domain;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static domain.LottoUtils.TICKET_PRICE;
import static domain.LottoUtils.inputParser;

public class LottoDAO {

    private static LottoDAO instance = new LottoDAO();

    private LottoDAO() {}

    public static LottoDAO getInstance() {
        return instance;
    }

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

    private PreparedStatement createPsmtAboutInsertUserInfo(Connection con, User user, String round, String inputMoney) throws SQLException {
        String sql = "INSERT INTO users VALUES(?,?,?,?)";
        PreparedStatement preparedStatement = con.prepareStatement(sql);
        preparedStatement.setInt(1, Integer.parseInt(round));
        preparedStatement.setString(2, user.getName());
        preparedStatement.setInt(3, Integer.parseInt(inputMoney));
        List<Integer> initPrize = Arrays.asList(0, 0, 0, 0, 0);
        preparedStatement.setString(4, initPrize.toString());
        return preparedStatement;
    }

    public void insertUserInfo(User user, String round, String inputMoney) {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = createPsmtAboutInsertUserInfo(connection, user, round, inputMoney)) {
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private PreparedStatement createPsmtAboutInsertLottosInfo(Connection con, User user, String round) throws SQLException {
        String sql = "INSERT INTO LOTTOS VALUES(?,?,?)";
        PreparedStatement preparedStatement = con.prepareStatement(sql);
        preparedStatement.setString(1, round);
        preparedStatement.setString(2, user.getName());
        return preparedStatement;
    }

    public void insertLottosInfo(User user, String round) {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = createPsmtAboutInsertLottosInfo(connection, user, round)) {
            for (Lotto lotto : user.getLottos()) {
                preparedStatement.setString(3, lotto.toString().replaceAll("[\\[\\]\"]", ""));
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private PreparedStatement createPsmtAboutRemoveUserInfo(Connection con, User user, String round) throws SQLException {
        String sql = "DELETE FROM users WHERE name = ? AND round = ?";
        PreparedStatement preparedStatement = getConnection().prepareStatement(sql);
        preparedStatement.setString(1, user.getName());
        preparedStatement.setInt(2, Integer.parseInt(round));
        return preparedStatement;
    }

    public void removeUserInfo(User user, String round) {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = createPsmtAboutRemoveUserInfo(connection, user, round)) {
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private PreparedStatement createPsmtAboutRemoveLottosInfo(Connection con, User user, String round) throws SQLException {
        String sql = "DELETE FROM lottos WHERE name = ? AND round = ?";
        PreparedStatement preparedStatement = getConnection().prepareStatement(sql);
        preparedStatement.setString(1, user.getName());
        preparedStatement.setInt(2, Integer.parseInt(round));
        return preparedStatement;
    }

    public void removeLottosInfo(User user, String round) {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = createPsmtAboutRemoveLottosInfo(connection, user, round)) {
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private PreparedStatement createPsmtAboutInsertWinningLotto(Connection con, String round, String winningNumber, String bonusNumber) throws SQLException {
        // add user information into USERS table
        String sql = "INSERT INTO winninglottos VALUES(?,?,?)";
        PreparedStatement preparedStatement = getConnection().prepareStatement(sql);
        preparedStatement.setInt(1, Integer.parseInt(round));
        preparedStatement.setString(2, winningNumber.replaceAll("[\\[\\]\"]", ""));
        preparedStatement.setInt(3, Integer.parseInt(bonusNumber));
        return preparedStatement;
    }

    public void insertWinningLotto(String round, String winningNumber, String bonusNumber) {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = createPsmtAboutInsertWinningLotto(connection, round, winningNumber, bonusNumber)) {
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private PreparedStatement createPsmtAboutRemoveWinningLotto(Connection con, String round) throws SQLException {
        String sql = "DELETE FROM winningLottos WHERE round = ?";
        PreparedStatement preparedStatement = getConnection().prepareStatement(sql);
        preparedStatement.setInt(1, Integer.parseInt(round));
        return preparedStatement;
    }

    public void removeWinningLotto(String round) {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = createPsmtAboutRemoveWinningLotto(connection, round)) {
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private PreparedStatement createPsmtAboutUpdateUserInfo(Connection con, User user, String round) throws SQLException {
        // update user's prize statistics
        String sql = "UPDATE users SET prizelist = ? WHERE name = ? AND round = ?";
        PreparedStatement preparedStatement = getConnection().prepareStatement(sql);
        preparedStatement.setString(2, user.getName());
        preparedStatement.setString(3, round);
        preparedStatement.setString(1, user.getPrizeStatistics().toString());
        return preparedStatement;
    }

    public void updateUserInfo(User user, String round) {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = createPsmtAboutUpdateUserInfo(connection, user, round)) {
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private PreparedStatement createPsmtAboutFindWinningNumberByRound(Connection con, String round) throws SQLException {
        String sql = "SELECT * FROM winninglottos WHERE round = ?";
        PreparedStatement preparedStatement = getConnection().prepareStatement(sql);
        preparedStatement.setInt(1, Integer.parseInt(round));
        return preparedStatement;
    }

    public LotteryCommission findWinningNumberByRound(String round) {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = createPsmtAboutFindWinningNumberByRound(connection, round);
             ResultSet rs = preparedStatement.executeQuery()) {
            if (rs.next()) {
                LotteryCommission lotteryCommission = new LotteryCommission(rs.getInt("round"));
                lotteryCommission.selectWinningNumbers(inputParser(rs.getString("lottoNo")),
                        LottoNo.of(rs.getInt("bonusNo")));
                return lotteryCommission;
            }
            return null;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    private PreparedStatement createPsmtAboutTakeLottoNoGroups(Connection con, String userName, String round) throws SQLException {
        String sql = "SELECT * FROM lottos WHERE name = ? AND round = ?";
        PreparedStatement preparedStatement = getConnection().prepareStatement(sql);
        preparedStatement.setString(1, userName);
        preparedStatement.setInt(2, Integer.parseInt(round));
        return preparedStatement;
    }

    private List<LottoNoGroup> takeLottoNoGroups(String userName, String round) {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = createPsmtAboutTakeLottoNoGroups(connection, userName, round);
             ResultSet rs = preparedStatement.executeQuery()) {
            List<LottoNoGroup> lottoNoGroups = new ArrayList<>();
            while (rs.next()) {
                lottoNoGroups.add(inputParser(rs.getString("lottoNo")));
            }
            return lottoNoGroups;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    private PreparedStatement createPsmtAboutTakeInputMoney(Connection con, String userName, String round) throws SQLException {
        String sql = "SELECT * FROM users WHERE name = ? AND round = ?";
        PreparedStatement preparedStatement = getConnection().prepareStatement(sql);
        preparedStatement.setString(1, userName);
        preparedStatement.setInt(2, Integer.parseInt(round));
        return preparedStatement;
    }

    private int takeInputMoney(String userName, String round) throws SQLException {
        int inputMoney = 0;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = createPsmtAboutTakeInputMoney(connection, userName, round);
             ResultSet rs = preparedStatement.executeQuery()) {
            if (rs.next()) {
                return Integer.parseInt(rs.getString("inputMoney"));
            }
            return inputMoney;
        } catch (SQLException e) {
            e.printStackTrace();
            return inputMoney;
        }
    }

    public User findUserByNameAndRoundFromUsers(String userName, String round) throws SQLException {
        User user = User.nameOf(userName);
        user.hasMoneyOf(takeInputMoney(userName, round));
        return user;
    }

    public User findUserByNameAndRoundFromLottos(String userName, String round) throws SQLException {
        User user = User.nameOf(userName);
        List<LottoNoGroup> lottoNoGroups = takeLottoNoGroups(userName, round);
        user.hasMoneyOf(lottoNoGroups.size() * TICKET_PRICE);
        user.purchaseTicketsManual(lottoNoGroups);
        return user;
    }
}
