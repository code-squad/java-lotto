package domain;

import java.sql.*;
import java.util.Arrays;

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

    public void insert(User user) throws SQLException {
        // add user information into USERS table
        String sql = "insert into USERS values(?,?,?,?,?,?)";
        PreparedStatement preparedStatement = getConnection().prepareStatement(sql);
        preparedStatement.setString(1, user.getName());
        preparedStatement.setString(2, String.valueOf(user.getPrizeStatistics().get(0))); // FIRST prize
        preparedStatement.setString(3, String.valueOf(user.getPrizeStatistics().get(1))); // SECOND prize
        preparedStatement.setString(4, String.valueOf(user.getPrizeStatistics().get(2))); // THIRD prize
        preparedStatement.setString(5, String.valueOf(user.getPrizeStatistics().get(3))); // FORTH prize
        preparedStatement.setString(6, String.valueOf(user.getPrizeStatistics().get(4))); // FIFTH prize
        preparedStatement.executeUpdate();

        // add lotto numbers information of user into LOTTO table
        sql = "insert into LOTTOS values(?,?)";
        preparedStatement = getConnection().prepareStatement(sql);

        for (Lotto lotto : user.getLottos()) {
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, lotto.toString());
        }
        preparedStatement.close();
    }

    public void update(User user) throws SQLException {
        // update user's prize statistics
        String sql = "update USERS set " +
                "FIRST = ?," +
                "SECOND = ?," +
                "THRID = ?," +
                "FORTH = ?," +
                "FIFTH = ?," +
                " where name = ?";
        PreparedStatement preparedStatement = getConnection().prepareStatement(sql);
        preparedStatement.setString(5, user.getName());
        preparedStatement.setString(1, String.valueOf(user.getPrizeStatistics().get(0))); // FIRST prize
        preparedStatement.setString(2, String.valueOf(user.getPrizeStatistics().get(1))); // SECOND prize
        preparedStatement.setString(3, String.valueOf(user.getPrizeStatistics().get(2))); // THIRD prize
        preparedStatement.setString(4, String.valueOf(user.getPrizeStatistics().get(3))); // FORTH prize
        preparedStatement.setString(5, String.valueOf(user.getPrizeStatistics().get(4))); // FIFTH prize
        preparedStatement.executeUpdate();
        }

    public void insert(LotteryCommission lotteryCommission) throws SQLException {
        // add user information into USERS table
        String sql = "insert into WINNINGLOTTOS values(?,?,?)";
        PreparedStatement preparedStatement = getConnection().prepareStatement(sql);
        preparedStatement.setString(1, String.valueOf(lotteryCommission.getRound()));
        preparedStatement.setString(2, lotteryCommission.getWinningLotto().toString());
        preparedStatement.setString(2, lotteryCommission.getWinningLotto().getBonusNum().toString());
        preparedStatement.close();
    }

    public User findResultByUserName(String userName) throws SQLException {
        String sql = "SELECT * FROM USERS where name = ?";
        PreparedStatement preparedStatement = getConnection().prepareStatement(sql);
        preparedStatement.setString(1, userName);

        ResultSet rs = preparedStatement.executeQuery();
        if (rs.next()) {
            User user = User.nameOf(rs.getString("userId"));
            user.setPrizeStatistics(Arrays.asList(
                    Integer.parseInt(rs.getString("FIRST")),
                    Integer.parseInt(rs.getString("SECOND")),
                    Integer.parseInt(rs.getString("THIRD")),
                    Integer.parseInt(rs.getString("FORTH")),
                    Integer.parseInt(rs.getString("FIFTH"))
            ));
            return user;
        }
        return null;
    }





}
