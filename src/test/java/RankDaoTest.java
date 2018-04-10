import dao.LottoDAO;
import dao.RankDAO;
import lotto.Lotto;
import lotto.LottoGame;
import lotto.WinningLotto;
import org.junit.Before;
import org.junit.Test;
import result.Result;

import java.sql.SQLException;

public class RankDaoTest {
    private LottoDAO lottoDao;
    private LottoGame game;
    private WinningLotto winningLotto;

    @Before
    public void setUp() {
        lottoDao = new LottoDAO();
        game = new LottoGame(lottoDao.readLottos());
        winningLotto = new WinningLotto(new Lotto("1,2,3,4,5,10"), 19);
    }

    @Test
    public void 등수db삽입() {
        Result result = game.match(winningLotto);
        RankDAO rankDAO = new RankDAO();
        rankDAO.insert(result);
    }
}
