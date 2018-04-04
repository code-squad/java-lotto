package lotto.lotto.domain;

import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class LottoDAOTest {

    @Test
    public void getConnectionTest() throws SQLException, ClassNotFoundException {
        LottoDAO test = new LottoDAO();
        Connection con = test.getConnection();
        assertNotNull(con);
    }

    @Test
    public void insertTest() throws SQLException, ClassNotFoundException {
        Lotto test1 = Lotto.of("35, 23, 2, 42, 21, 13");
        Lotto test2 = Lotto.of("5, 6, 7, 8, 9, 10");
        List<Lotto> testList = new ArrayList<>();
        testList.add(test1);
        testList.add(test2);

        LottoDAO test4 = new LottoDAO();
        test4.deleteLottos();
        test4.insertLottos(testList);

    }

    @Test
    public void insertRankTest() throws SQLException, ClassNotFoundException {
        LottoDAO test4 = new LottoDAO();

        Map<Rank, Integer> numberOfRank = new HashMap<>();
        for (Rank r : Rank.values()) {
            numberOfRank.put(r, 0);
        }
        numberOfRank.put(Rank.FIRST, 3);
        test4.insertRank(numberOfRank);
    }
}