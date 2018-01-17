package enums;

import org.junit.Test;

import java.util.LinkedHashMap;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class WinningRulesTest {

    @Test
    public void findByMatchCount(){
        assertThat(WinningRules.findByMatchCount(0), is(WinningRules.NONE));
        assertThat(WinningRules.findByMatchCount(1), is(WinningRules.ONE_MATCHING));
        assertThat(WinningRules.findByMatchCount(2), is(WinningRules.TWO_MATCHING));
        assertThat(WinningRules.findByMatchCount(3), is(WinningRules.THREE_MATCHING));
        assertThat(WinningRules.findByMatchCount(4), is(WinningRules.FOUR_MATCHING));
        assertThat(WinningRules.findByMatchCount(5), is(WinningRules.FIVE_MATCHING));
        assertThat(WinningRules.findByMatchCount(6), is(WinningRules.SIX_MATCHING));
    }

    @Test
    public void getNewKeyMap(){
        Map<WinningRules, Integer> winningRulesKeyMap = new LinkedHashMap<>();

        winningRulesKeyMap.put(WinningRules.THREE_MATCHING, 0);
        winningRulesKeyMap.put(WinningRules.FOUR_MATCHING, 0);
        winningRulesKeyMap.put(WinningRules.FIVE_MATCHING, 0);
        winningRulesKeyMap.put(WinningRules.SIX_MATCHING, 0);

        assertThat(WinningRules.getNewKeyMap(), is(winningRulesKeyMap));
    }
}
