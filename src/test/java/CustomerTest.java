import DTO.LottoResult;
import DTO.WinningLotto;
import model.Customer;
import model.Lotto;
import model.Rank;
import org.junit.Before;
import org.junit.Test;

import javax.swing.text.MaskFormatter;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class CustomerTest {

    private Customer customer;

    @Before
    public void setUp(){
        customer = new Customer();
    }

    @Test
    public void buy(){
        assertThat(customer.buy(14000).size()).isEqualTo(14);
    }

    @Test
    public void getHitNumbers(){
        customer.buy(14000);
        assertThat(customer.getHitNumbers("1,2,3,4,5,6").size()).isEqualTo(14);
    }

    @Test
    public void analyze(){
        customer.buy(3000);
        Map<Rank, Integer> winningLottoByRank = new HashMap();
        assertThat(customer.analyze(winningLottoByRank)).isBetween(-100.0, 100.0);
    }

    @Test
    public void convertFromHitNumsToRank(){
        Map<Lotto, Integer> hitNumbersForEachLotto = new HashMap();
        Lotto lotto1 = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto lotto3 = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        hitNumbersForEachLotto.put(lotto1, 3);
        hitNumbersForEachLotto.put(lotto2, 1);
        hitNumbersForEachLotto.put(lotto3, 0);

        assertThat(customer.convertFromHitNumsToRank(hitNumbersForEachLotto,3).getWinningLotto().size()).isEqualTo(1);
    }

    @Test
    public void match(){
        customer.buy(3000);
        assertThat(customer.match("1,2,3,4,5,6", 8)).isExactlyInstanceOf(LottoResult.class);
    }
}
