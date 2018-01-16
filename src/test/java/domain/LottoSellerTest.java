package domain;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoSellerTest {
    //BuyInfomation정보를 넘기면, 수동을 제외한 것을 생성하여 리턴한다.
    private BuyInfo buyInfo;
    private List<Ticket> ticketList;

    @Before
    public void init() {
        List<Ticket> ticketList = new ArrayList<>();
        for(int i = 0 ; i < 3 ; ++i)
            ticketList.add(new Ticket(Arrays.asList(10, 11, 12, 13, 14, 15)));

        Tickets tickets = new Tickets(ticketList);
        buyInfo = new BuyInfo(10000, tickets);
    }

    @Test
    public void lottoSellerTest() {
        List<Lotto> lottos = LottoSeller.buyLotto(buyInfo, () -> Arrays.asList(1, 2, 3, 4, 5, 6));

        assertThat(lottos.size()).isEqualTo(10);
        for (int i = 0 ; i < ticketList.size() ; i++)
            assertThat(lottos.get(i).toString()).isEqualTo(Arrays.asList(10, 11, 12, 13, 14, 15).toString());
        for (int i = ticketList.size() ; i < 10 ; i++)
            assertThat(lottos.get(i).toString()).isEqualTo(Arrays.asList(1, 2, 3, 4, 5, 6).toString());
    }
}
