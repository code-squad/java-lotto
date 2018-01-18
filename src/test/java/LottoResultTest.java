import dto.LottoResult;
import model.Customer;
import model.Lotto;
import model.Rank;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoResultTest {

    @Test
    public void analyze(){
        Customer customer = new Customer();
//        List<Lotto> lottos = customer.buy(3000);
        LottoResult lottoResult = new LottoResult(init());

//        assertThat(lottoResult.analyze(lottos)).isBetween(-100.0, 100.0);
    }

    private Map<Rank, Integer> init() {
        Map<Rank, Integer> winningLottoByRank = new HashMap();

        for (Rank rank : Rank.values()) {
            winningLottoByRank.put(rank, 0);
        }
        return winningLottoByRank;
    }
}
