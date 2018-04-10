import dao.LottoDAO;
import dao.RankDAO;
import lotto.Lotto;
import lotto.LottoGame;
import lotto.WinningLotto;
import org.junit.Before;
import org.junit.Test;
import result.Result;
import static org.junit.Assert.*;
import java.sql.SQLException;

public class LottoResultTest {
    private LottoDAO lottoDao;
    private LottoGame game;
    private WinningLotto winningLotto;
    private Result result;

    @Before
    public void setUp() throws SQLException {
        lottoDao = new LottoDAO();
        game = new LottoGame(lottoDao.readLottos());
        winningLotto = new WinningLotto(new Lotto("1,2,3,4,5,10"), 19);
    }

    @Test
    public void 등수출력() throws SQLException {
        Result result = game.match(winningLotto);
        System.out.println(result.getRanks());
    }

    @Test
    public void 등수db삽입() throws SQLException {
        Result result = game.match(winningLotto);
        RankDAO rankDAO = new RankDAO();
        rankDAO.insert(result);
    }
}
