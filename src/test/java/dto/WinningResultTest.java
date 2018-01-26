package dto;

import domain.lotto.LottoTicket;
import enums.WinningRules;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class WinningResultTest {

    List<WinningRules> rules;
    List<LottoTicket> tickets;
    LottoTicket winningTicket;

    @Before
    public void init() {
        rules = Arrays.asList(
                WinningRules.THREE_MATCHING,
                WinningRules.THREE_MATCHING
        );

        winningTicket = new LottoTicket("1, 2, 3, 4, 5, 6");

        LottoTicket ticket1 = new LottoTicket("1, 2, 3, 4, 5, 6");
        LottoTicket ticket2 = new LottoTicket("7, 8, 9, 10, 11, 12");
        LottoTicket ticket3 = new LottoTicket("13, 14, 15, 16, 17, 18");
        LottoTicket ticket4 = new LottoTicket("19, 20, 21, 22, 23, 24");
        LottoTicket ticket5 = new LottoTicket("25, 26, 27, 28, 29, 30");
        LottoTicket ticket6 = new LottoTicket("31, 32, 33, 34, 35, 36");
        LottoTicket ticket7 = new LottoTicket("37, 38, 39, 40, 41, 42");

        tickets = Arrays.asList(
                ticket1,
                ticket2,
                ticket3,
                ticket4,
                ticket5,
                ticket6,
                ticket7
        );
    }

    @Test
    public void findByMatchCount_테스트() {
        assertThat(WinningResult.findByMatchCount(0, false), is(WinningRules.NONE));
        assertThat(WinningResult.findByMatchCount(1, false), is(WinningRules.NONE));
        assertThat(WinningResult.findByMatchCount(2, false), is(WinningRules.NONE));
        assertThat(WinningResult.findByMatchCount(3, false), is(WinningRules.THREE_MATCHING));
        assertThat(WinningResult.findByMatchCount(4, false), is(WinningRules.FOUR_MATCHING));
        assertThat(WinningResult.findByMatchCount(5, false), is(WinningRules.FIVE_MATCHING));
        assertThat(WinningResult.findByMatchCount(5, true), is(WinningRules.BONUS_MATCHING));
        assertThat(WinningResult.findByMatchCount(6, false), is(WinningRules.SIX_MATCHING));
    }

    @Test
    public void getNewKeyMap() {
        Map<WinningRules, Integer> winningRulesKeyMap = new LinkedHashMap<>();

        winningRulesKeyMap.put(WinningRules.THREE_MATCHING, 0);
        winningRulesKeyMap.put(WinningRules.FOUR_MATCHING, 0);
        winningRulesKeyMap.put(WinningRules.FIVE_MATCHING, 0);
        winningRulesKeyMap.put(WinningRules.BONUS_MATCHING, 0);
        winningRulesKeyMap.put(WinningRules.SIX_MATCHING, 0);

        assertThat(WinningResult.getNewKeyMap(), is(winningRulesKeyMap));
    }

    @Test
    public void countRules() {

        WinningResult result = new WinningResult(14000, rules);

        assertThat(result.countRules(rules).get(WinningRules.THREE_MATCHING), is(2));
    }

    @Test
    public void calculateWinningPercent() {
        WinningResult result = new WinningResult(14000, rules);

        assertThat(result.calculateWinningPercent(1000, 1000), is(0));
    }

    @Test
    public void calculateWinningMoney() {
        WinningResult result = new WinningResult(14000, rules);

        Map<WinningRules, Integer> rules = new HashMap() {{
            put(WinningRules.THREE_MATCHING, 2);
        }};

        assertThat(result.calculateWinningMoney(rules), is(10000));
    }
}
