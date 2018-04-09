package lotto;

import lotto.domain.Lotto;
import lotto.domain.Results;
import lotto.domain.WinningLotto;
import lotto.domain.generation.Number;
import lotto.domain.generation.Ticket;
import org.junit.Before;
import org.junit.Test;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class LottoDAOTest {
    private LottoDAO lottoDAO;
    private Lotto lotto;
    private WinningLotto winningLotto;

    @Before
    public void setUp() {
        lottoDAO = new LottoDAO();
        Ticket ticket = new Ticket(Arrays.asList(new Number(1), new Number(2), new Number(3), new Number(4), new Number(5), new Number(6)));
        List<Ticket> auto = new ArrayList<>(Arrays.asList(ticket));
        List<Ticket> manual = new ArrayList<>(Arrays.asList(ticket));
        lotto = new Lotto(auto, manual);
        winningLotto = new WinningLotto(ticket, new Number(8));
    }

    @Test
    public void connection() {
        Connection connection = lottoDAO.getConnection();
        assertNotNull(connection);
    }

    @Test
    public void addToUserInput() {
        lottoDAO.addToUserLotto(lotto);
    }

    @Test
    public void renewUserLottoTable() {
        lottoDAO.renewUserLottoTable();
    }

    @Test
    public void renewResultTable() {
        lottoDAO.renewResultTable();
    }

    @Test
    public void addToResult() {
        Results results = new Results(lotto, winningLotto);
        lottoDAO.addToResult(results);
    }
}