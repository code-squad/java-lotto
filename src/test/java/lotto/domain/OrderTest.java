package lotto.domain;

import lotto.view.ResultView;
import org.junit.Before;
import org.junit.Test;

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
    public void checkWinning(){
        int[] luckyNumbers = new int[]{1,2,3,4,5,6};

        order.purchase();
        List<Lotto> lottos = order.checkWinning(luckyNumbers);

        ResultView.printWinningResult(lottos);
        ResultView.printEarningsRate(order);
    }

    @Test
    public void getEarnings(){
        int[] luckyNumbers = new int[]{1,2,3,4,5,6};

        order.purchase();
        order.checkWinning(luckyNumbers);

        double totalEarnings = order.getTotalPrizes() - TOTAL_COST;

        int earningsRate = (int) (totalEarnings / TOTAL_COST * 100);
        System.out.println("total prizes: "+order.getTotalPrizes()+", earnings rate: "+earningsRate+"%");
        assertThat(order.getEarningsRate()).isEqualTo(earningsRate);

    }

}