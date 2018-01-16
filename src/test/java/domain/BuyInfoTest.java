package domain;

import jdk.nashorn.internal.ir.LiteralNode;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class BuyInfoTest {
    private BuyInfo buyInfo;

    @Before
    public void init() {
        List<Ticket> tickets = new ArrayList<>();
        tickets.add(new Ticket(Arrays.asList(1, 2, 3, 4, 5, 6)));
        tickets.add(new Ticket(Arrays.asList(1, 2, 3, 4, 5, 6)));
        tickets.add(new Ticket(Arrays.asList(1, 2, 3, 4, 5, 6)));
        buyInfo = new BuyInfo(10000, new Tickets(tickets));
    }

    @Test
    public void buyInfoTest() {
        BuyInfo buyInfo = new BuyInfo(10000, new Tickets(new ArrayList<Ticket>()));
    }

    @Test
    public void getPurchasableAutoLottoQuantityTest() {
        assertThat(buyInfo.getPurchasableQuantity(1000)).isEqualTo(7);
    }

    @Test
    public void getPurchasableTotalLottoQuantityTest() {
        assertThat(buyInfo.getPurchasableTotalQuantity(1000)).isEqualTo(10);
    }

    @Test
    public void addManualLotto() {
        List<Lotto> lottos = buyInfo.addManualLotto(new ArrayList<Lotto>());
        assertThat(lottos.size()).isEqualTo(3);
    }
}
