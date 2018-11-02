package lottogame.util;

import java.sql.*;

public class SqlSet {
    public Connection con;
    public PreparedStatement stmt;
    public ResultSet rs;

    public SqlSet() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void makeConnection(String url, String user, String password) throws SQLException {
        this.con = DriverManager.getConnection(url, user, password);
    }

    public void prepareStatement(String query) throws SQLException {
        stmt = con.prepareStatement(query);
    }

    public void executeQuery() throws SQLException {
        rs = stmt.executeQuery();
    }

    public String getFirst(String column) throws SQLException {
        rs.next();
        return rs.getString(column);
    }

    public void setString(int index, String value) throws SQLException {
        stmt.setString(index, value);
    }

    public void setInt(int index, int value) throws SQLException {
        stmt.setInt(index, value);
    }

    public Boolean execute() throws SQLException {
        return stmt.execute();
    }

    public void close() {
        try {
            if (rs != null) {
                System.out.println("rs");
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (stmt != null) {
                System.out.println("stmt");
                stmt.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if (con != null) {
                System.out.println("con");
                con.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
