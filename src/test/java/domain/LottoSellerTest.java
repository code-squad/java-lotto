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
        ticketList = new ArrayList<>();
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
            assertThat(lottos.get(i)).isEqualTo(new Lotto(() -> Arrays.asList(10, 11, 12, 13, 14, 15)));
        for (int i = ticketList.size() ; i < 10 ; i++)
            assertThat(lottos.get(i)).isEqualTo(new Lotto(() -> Arrays.asList(1, 2, 3, 4, 5, 6)));
    }

    @Test
    public void buyTicketTest() {
        List<List<Integer>> nums = new ArrayList<>();
        nums.add(Arrays.asList(1, 2, 3, 4, 5, 6));
        nums.add(Arrays.asList(1, 2, 3, 4, 5, 7));
        nums.add(Arrays.asList(1, 2, 3, 4, 7, 8));
        nums.add(Arrays.asList(1, 2, 3, 7, 8, 9));


        Tickets ticket = LottoSeller.buyTickets(nums);
        List<Ticket> tickets = ticket.getTickets();
        assertThat(tickets.get(0).getNums()).isEqualTo(Arrays.asList(1, 2, 3, 4, 5, 6));
        assertThat(tickets.get(1).getNums()).isEqualTo(Arrays.asList(1, 2, 3, 4, 5, 7));
        assertThat(tickets.get(2).getNums()).isEqualTo(Arrays.asList(1, 2, 3, 4, 7, 8));
        assertThat(tickets.get(3).getNums()).isEqualTo(Arrays.asList(1, 2, 3, 7, 8, 9));
    }
}
