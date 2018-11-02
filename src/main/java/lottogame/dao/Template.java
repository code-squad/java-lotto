package lottogame.dao;

import lottogame.util.Function;
import lottogame.util.SqlSet;

import java.sql.SQLException;

public class Template {
    static <R> R exceptionHandle(Function<R> function) {
        SqlSet sqlSet = new SqlSet();
        try {
            return function.apply(sqlSet);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            sqlSet.close();
        }
        return null;

    }
}
