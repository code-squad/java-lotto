package domain;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class BuyInfoTest {
    private BuyInfo buyInfo;

    @Before
    public void init() {
        buyInfo = new BuyInfo(10000, new Tickets(new ArrayList<Ticket>()));
    }

    @Test
    public void buyInfoTest() {
        BuyInfo buyInfo = new BuyInfo(10000, new Tickets(new ArrayList<Ticket>()));
    }

    @Test
    public void getPurchasableAutoLottoQuantityTest() {
        assertThat(buyInfo.getPurchasableQuantity(1000)).isEqualTo(10);
    }

    @Test
    public void getPurchasableTotalLottoQuantityTest() {
        assertThat(buyInfo.getPurchasableTotalQuantity(1000)).isEqualTo(10);
    }

    @Test
    public void getTicketsTest() {
    }
}
