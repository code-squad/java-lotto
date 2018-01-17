package lotto.domain;

import lotto.dto.WinningDTO;
import lotto.view.ResultView;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class OrderTest {
    private static final int TOTAL_COST = 14000;
    private Order order;

    @Before
    public void setUp() throws Exception {
        order = new Order(TOTAL_COST);
    }

    @Test
    public void purchase() {
        List<Lotto> lottos = order.purchase();
        assertThat(lottos).isNotNull();
        assertThat(lottos.size()).isEqualTo(14);

        ResultView.printLottos(lottos);
    }

    @Test
    public void getEarnings(){
        order.purchase();
        WinningDTO winningResult = order.checkWinning(Arrays.asList(1,2,3,4,5,6));

        double totalEarnings = winningResult.getTotalPrizes() - TOTAL_COST;

        int earningsRate = (int) (totalEarnings / TOTAL_COST * 100);
        System.out.println("total prizes: "+winningResult.getTotalPrizes()+", earnings rate: "+earningsRate+"%");
        assertThat(winningResult.getEarningsRate()).isEqualTo(earningsRate);

    }

}