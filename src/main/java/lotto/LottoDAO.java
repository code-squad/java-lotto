package lotto;

import lotto.domain.Lotto;
import lotto.domain.Match;
import lotto.domain.Results;

import java.sql.*;
import java.util.*;

public class LottoDAO {
    private static final String USER_LOTTO_TABLE = "userLotto";
    private static final String RESULT_TABLE = "result";
    private static LottoDAO lottoDAO;

    private LottoDAO() {
    }

    public static LottoDAO getInstance() {
        if (lottoDAO == null) {
            lottoDAO = new LottoDAO();
            return lottoDAO;
        }
        return lottoDAO;
    }

    public Connection getConnection() {
        String url = "jdbc:mysql://192.168.56.101:3306/lotto";
        String id = "krapeaj";
        String password = "krapeaj";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection(url, id, password);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public void addToUserLotto(Lotto lotto) {
        String sql = "INSERT INTO " + USER_LOTTO_TABLE + "(first,second,third,fourth,fifth,sixth) values(?,?,?,?,?,?)";
        try (Connection connection = getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {

            int ticketCount = lotto.getNumberOfTickets();
            for (int i = 0; i < ticketCount; i++) {
                List<Integer> numbers = lotto.getNumbers(i);
                pstmt.setInt(1, numbers.get(0));
                pstmt.setInt(2, numbers.get(1));
                pstmt.setInt(3, numbers.get(2));
                pstmt.setInt(4, numbers.get(3));
                pstmt.setInt(5, numbers.get(4));
                pstmt.setInt(6, numbers.get(5));

                pstmt.execute();
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void renewUserLottoTable() {
        try (Connection connection = getConnection();
             Statement stmt = connection.createStatement()) {

            String sql = "DROP TABLE IF EXISTS " + USER_LOTTO_TABLE;
            stmt.executeUpdate(sql);

            sql = "CREATE TABLE " + USER_LOTTO_TABLE +
                    "(count TINYINT PRIMARY KEY AUTO_INCREMENT," +
                    "first TINYINT NOT NULL," +
                    "second TINYINT NOT NULL," +
                    "third TINYINT NOT NULL," +
                    "fourth TINYINT NOT NULL," +
                    "fifth TINYINT NOT NULL," +
                    "sixth TINYINT NOT NULL" +
                    ");";
            stmt.executeUpdate(sql);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void renewResultTable() {
        try (Connection connection = getConnection();
             Statement stmt = connection.createStatement()) {
            String sql = "DROP TABLE IF EXISTS " + RESULT_TABLE;
            stmt.executeUpdate(sql);

            sql = "CREATE TABLE " + RESULT_TABLE +
                    "(rank CHAR(16) NOT NULL," +
                    "count TINYINT DEFAULT 0);";
            stmt.executeUpdate(sql);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void addToResult(Results results) {
        String sql = "INSERT INTO " + RESULT_TABLE + " VALUES(?,?);";
        try (Connection connection = getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {

            for (Match rank : Match.values()) {
                pstmt.setString(1, rank.identify(rank));
                pstmt.setInt(2, results.getCount(rank));
                pstmt.execute();
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


    public List<List<Integer>> getFromUserLotto() {
        try (Connection connection = getConnection();
             Statement stmt = connection.createStatement()) {

            String sql = "SELECT * FROM " + USER_LOTTO_TABLE;
            ResultSet rs = stmt.executeQuery(sql);
            List<List<Integer>> numbers = new ArrayList<>();
            while (rs.next()) {
                int first = rs.getInt("first");
                int second = rs.getInt("second");
                int third = rs.getInt("third");
                int fourth = rs.getInt("fourth");
                int fifth = rs.getInt("fifth");
                int sixth = rs.getInt("sixth");
                numbers.add(Arrays.asList(first, second, third, fourth, fifth, sixth));
            }
            return numbers;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public Map<String, Integer> getFromResult() {
        try (Connection connection = getConnection();
             Statement stmt = connection.createStatement()) {

            String sql = "SELECT * FROM " + RESULT_TABLE;
            ResultSet rs = stmt.executeQuery(sql);
            Map<String, Integer> result = new HashMap<>();
            while (rs.next()) {
                String rank = rs.getString("rank");
                int count = rs.getInt("count");
                result.put(rank, count);
            }
            return result;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}