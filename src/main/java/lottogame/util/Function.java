package lottogame.util;

import java.sql.SQLException;

public interface Function<R> {
    R apply(SqlSet sqlSet) throws SQLException;
}
