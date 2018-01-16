package domain;

import org.junit.Test;

import java.util.ArrayList;

public class BuyInfoTest {
    @Test
    public void buyInfoTest() {
        BuyInfo buyInfo = new BuyInfo(10000, new Tickets(new ArrayList<Ticket>()));
    }
}
