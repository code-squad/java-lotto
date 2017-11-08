package lotto.model;

import static org.junit.Assert.*;

import org.junit.Test;

import lotto.model.MatchingResults.Match;

public class MatchingResultsTest {
    @Test
    public void match_valid() throws Exception {
        assertEquals(Match.MATCH3, Match.valueOf(3));
        assertEquals(Match.MATCH4, Match.valueOf(4));
        assertEquals(Match.MATCH5, Match.valueOf(5));
        assertEquals(Match.MATCH6, Match.valueOf(6));
    }
    
    @Test(expected = IllegalArgumentException.class )
    public void match_invalid() throws Exception {
        Match.valueOf(1);
    }
    
    @Test
    public void winningMoney() throws Exception {
        int countOfMatch = 3;
        int countOfLotto = 4;
        long winningMoney = Match.valueOf(countOfMatch).winningMoney(countOfLotto);
        assertEquals(20000, winningMoney);
    }
    
    @Test
    public void getProfit() {
        MatchingResults result = new MatchingResults(5);
        result.add(Match.MATCH3);
        assertEquals(100.0, result.getProfit(), 0.001);
        
        result.add(Match.MATCH4);
        assertEquals(1100.0, result.getProfit(), 0.001);
    }
    
}
