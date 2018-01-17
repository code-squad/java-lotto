package DTO;

import domain.lotto.LottoTicket;
import enums.WinningRules;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class WinningResultTest {

    ArrayList<WinningRules> rules;
    WinningResult winningResult;
    List<LottoTicket> tickets;
    LottoTicket winningTicket;

    @Before
    public void init(){
        rules = new ArrayList() {{
            add(WinningRules.THREE_MATCHING);
            add(WinningRules.THREE_MATCHING);
        }};

        winningTicket = new LottoTicket();
        winningTicket.insertNumber("1, 2, 3, 4, 5, 6");

        LottoTicket ticket1 = new LottoTicket();
        ticket1.insertNumber("1, 2, 3, 4, 5, 6");
        LottoTicket ticket2 = new LottoTicket();
        ticket2.insertNumber("7, 8, 9, 10, 11, 12");
        LottoTicket ticket3 = new LottoTicket();
        ticket3.insertNumber("13, 14, 15, 16, 17, 18");
        LottoTicket ticket4 = new LottoTicket();
        ticket4.insertNumber("19, 20, 21, 22, 23, 24");
        LottoTicket ticket5 = new LottoTicket();
        ticket5.insertNumber("25, 26, 27, 28, 29, 30");
        LottoTicket ticket6 = new LottoTicket();
        ticket6.insertNumber("31, 32, 33, 34, 35, 36");
        LottoTicket ticket7 = new LottoTicket();
        ticket7.insertNumber("37, 38, 39, 40, 41, 42");

        tickets = new ArrayList() {{
            add(ticket1);
            add(ticket2);
            add(ticket3);
            add(ticket4);
            add(ticket5);
            add(ticket6);
            add(ticket7);
        }};
    }

    @Test
    public void countRules(){

        WinningResult result= new WinningResult(14000, winningTicket, tickets);

        assertThat(result.countRules(rules).get(WinningRules.THREE_MATCHING), is(2));
    }

    @Test
    public void findMatching_하나() {
        winningTicket = new LottoTicket();
        winningTicket.insertNumber("1, 2, 3, 4, 5, 6");

        LottoTicket ticket1 = new LottoTicket();
        ticket1.insertNumber("1, 2, 3, 4, 5, 6");
        LottoTicket ticket2 = new LottoTicket();
        ticket2.insertNumber("7, 8, 9, 10, 11, 12");
        LottoTicket ticket3 = new LottoTicket();
        ticket3.insertNumber("13, 14, 15, 16, 17, 18");
        LottoTicket ticket4 = new LottoTicket();
        ticket4.insertNumber("19, 20, 21, 22, 23, 24");
        LottoTicket ticket5 = new LottoTicket();
        ticket5.insertNumber("25, 26, 27, 28, 29, 30");
        LottoTicket ticket6 = new LottoTicket();
        ticket6.insertNumber("31, 32, 33, 34, 35, 36");
        LottoTicket ticket7 = new LottoTicket();
        ticket7.insertNumber("37, 38, 39, 40, 41, 42");

        tickets = new ArrayList() {{
            add(ticket1);
            add(ticket2);
            add(ticket3);
            add(ticket4);
            add(ticket5);
            add(ticket6);
            add(ticket7);
        }};

        winningResult = new WinningResult(14000, winningTicket, tickets);

        List<WinningRules> matching = winningResult.findMatching(winningTicket, tickets);

        assertThat(matching.get(0), is(WinningRules.SIX_MATCHING));
    }

    @Test
    public void findMatching_여러개() {
        LottoTicket winningTicket = new LottoTicket();
        winningTicket.insertNumber("1, 2, 3, 4, 5, 6");

        LottoTicket ticket1 = new LottoTicket();
        ticket1.insertNumber("1, 2, 3, 4, 5, 6");//6개
        LottoTicket ticket2 = new LottoTicket();
        ticket2.insertNumber("1, 2, 3, 10, 11, 12");//3개
        LottoTicket ticket3 = new LottoTicket();
        ticket3.insertNumber("4, 5, 6, 16, 17, 18");//3개
        LottoTicket ticket4 = new LottoTicket();
        ticket4.insertNumber("5, 6, 21, 22, 23, 24");//2개
        LottoTicket ticket5 = new LottoTicket();
        ticket5.insertNumber("25, 26, 27, 28, 29, 30");
        LottoTicket ticket6 = new LottoTicket();
        ticket6.insertNumber("31, 32, 33, 34, 35, 36");
        LottoTicket ticket7 = new LottoTicket();
        ticket7.insertNumber("37, 38, 39, 40, 41, 42");

        List<LottoTicket> tickets = new ArrayList() {{
            add(ticket1);
            add(ticket2);
            add(ticket3);
            add(ticket4);
            add(ticket5);
            add(ticket6);
            add(ticket7);
        }};

        winningResult = new WinningResult(14000, winningTicket, tickets);

        List<WinningRules> matching = winningResult.findMatching(winningTicket, tickets);

        ArrayList answer = new ArrayList() {{
            add(WinningRules.SIX_MATCHING);
            add(WinningRules.THREE_MATCHING);
            add(WinningRules.THREE_MATCHING);
        }};

        assertThat(matching, is(answer));
    }

    @Test
    public void calculateWinningPercent(){
        WinningResult result= new WinningResult(14000, winningTicket, tickets);

        assertThat(result.calculateWinningPercent(1000, 1000), is(0));
    }

    @Test
    public void calculateWinningMoney(){
        WinningResult result= new WinningResult(14000, winningTicket, tickets);

        Map<WinningRules, Integer> rules = new HashMap() {{
            put(WinningRules.THREE_MATCHING, 2);
        }};

        assertThat(result.calculateWinningMoney(rules), is(10000));
    }
}
