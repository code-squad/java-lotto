package lotto;

import org.junit.Test;

import java.sql.Connection;

import static org.junit.Assert.*;

public class LottoDAOTest {

    @Test
    public void connection() {
        LottoDAO lottoDAO = new LottoDAO();
        Connection connection = lottoDAO.getConnection();
        assertNotNull(connection);
    }
}