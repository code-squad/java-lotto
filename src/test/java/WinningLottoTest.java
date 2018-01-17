import dto.LottoResult;
import model.Customer;
import model.Lotto;
import model.Rank;
import model.WinningLotto;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningLottoTest {

    private Customer customer = new Customer();
    private WinningLotto winningLotto;

    @Before
    public void setUp(){
        Lotto lotto = new Lotto(Arrays.asList(1,2,3,4,5,6));
        winningLotto = new WinningLotto(lotto, 9);
    }

    @Test
    public void analyze(){
        customer.buy(3000);
        Map<Rank, Integer> winningLottoByRank = new HashMap();

        for (Rank rank : Rank.values()) {
            winningLottoByRank.put(rank, 0);
        }

        assertThat(winningLotto.analyze(customer.getLottos(), winningLottoByRank)).isBetween(-100.0, 100.0);
    }

    @Test
    public void match(){
        Map<Lotto, Rank> lottoRankMap = new HashMap();
        assertThat(winningLotto.match(customer.getLottos(), lottoRankMap)).isExactlyInstanceOf(LottoResult.class);
    }

    @Test
    public void convertFromHitNumsToRank(){
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));

        assertThat(winningLotto.convertFromHitNumsToRank(lotto,3)).isEqualTo(Rank.FIFTH);
    }

    @Test
    public void compare(){
        Lotto lotto = new Lotto(Arrays.asList(1,2,3,4,5,6));

        assertThat(winningLotto.compare(lotto)).isEqualTo(Rank.FIRST);
    }
}
