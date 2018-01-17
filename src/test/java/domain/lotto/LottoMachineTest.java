package domain.lotto;

import enums.WinningRules;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


public class LottoMachineTest {

    private LottoMachine lottoMachine;

    @Before
    public void init() {
        lottoMachine = new LottoMachine();
    }

    @Test
    public void InputMoney() {
        lottoMachine.insertMoney("14000");
        assertThat(lottoMachine.getMoney(), is(14000));
    }

    @Test
    public void buy_lottoTicket() {
        List<LottoTicket> lottoTickets = lottoMachine.createLottoTicket(14);
        assertThat(lottoTickets.size(), is(14));
    }

    @Test
    public void InputLastWeekWinningNumber() {
        lottoMachine.inputWinningNumber("1, 2, 3, 4, 5, 6");
        LottoTicket ticket = new LottoTicket();
        ticket.insertNumber("1, 2, 3, 4, 5, 6");
        assertThat(lottoMachine.getWinningTicket(), is(ticket));
    }



    @Test
    public void calculate() {
        ArrayList<WinningRules> rules = new ArrayList() {{
            add(WinningRules.THREE_MATCHING);
            add(WinningRules.THREE_MATCHING);
        }};
        Integer price = 0;
        for (WinningRules rule : rules) {
            price += rule.getReward();
        }

        assertThat(price, is(10000));
    }
}
