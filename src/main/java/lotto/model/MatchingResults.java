package lotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MatchingResults {
    private List<MatchingResult> results = new ArrayList<>();
    
    private int countOfLotto;

    public MatchingResults(int countOfLotto) {
        this.countOfLotto = countOfLotto;
        
        results.add(new MatchingResult(Match.MATCH3));
        results.add(new MatchingResult(Match.MATCH4));
        results.add(new MatchingResult(Match.MATCH5));
        results.add(new MatchingResult(Match.MATCH6));
    }

    public void add(Match match) {
        if (match == null) {
            return;
        }
        
        // results.stream().filter(e -> e.supports(match)).findFirst().get().match();
        
        MatchingResult matchingResult = getMatchingResult(match);
        
        if (matchingResult != null) {
        	matchingResult.match();
        }
    }

	private MatchingResult getMatchingResult(Match match) {
		MatchingResult matchingResult = null;
        for (MatchingResult e : results) {
			if (e.supports(match)) {
				matchingResult = e;
			}
		}
		return matchingResult;
	}

    public double getProfit() {
        int buyingMoney = countOfLotto * UserLotto.MONEY_PER_TICKET;
        long winningMoney = 0;
        
        for (MatchingResult matchingResult : results) {
            winningMoney += matchingResult.winningMoney();
        }
        
        System.out.println("Winning Money : " + winningMoney);
        return (winningMoney * 100) / buyingMoney;
    }
    
    public List<MatchingResult> getResults() {
        return Collections.unmodifiableList(results);
    }
    
    public int getCountOfLotto() {
        return countOfLotto;
    }
    
    public int getCountOfMatch(Match match) {
    	return getMatchingResult(match).getCountOfMatch();
    }
    
    public enum Match {
        MATCH3(3, 5000),
        MATCH4(4, 50000),
        MATCH5(5, 1500000),
        MATCH6(6, 2000000000);
        
        private int countOfMatch;
        private int winningMoney;

        private Match(int countOfMatch, int winningMoney) {
            this.countOfMatch = countOfMatch;
            this.winningMoney = winningMoney;
        }

        public static Match valueOf(int countOfMatch) {
            Match[] values = values();
            for (Match match : values) {
                if (match.countOfMatch == countOfMatch) {
                    return match;
                }
            }
            throw new IllegalArgumentException(countOfMatch + "는 유효하지 않은 값입니다.");
        }

        long winningMoney(int countOfMatchingLotto) {
            return winningMoney * countOfMatchingLotto;
        }
        
        public int getCountOfMatch() {
            return countOfMatch;
        }
        
        public int getWinningMoney() {
            return winningMoney;
        }
    }
    
    public static class MatchingResult {
        private int countOfMatchingLotto = 0;
        private Match match;

        private MatchingResult(Match match) {
            this.match = match;
        }
        
        private boolean supports(Match match) {
            return this.match == match;
        }
        
        private void match() {
            countOfMatchingLotto++;
        }
        
        public int getCountOfMatchingLotto() {
            return countOfMatchingLotto;
        }
        
        public int getCountOfMatch() {
            return match.getCountOfMatch();
        }
        
        public long winningMoney() {
            return match.winningMoney(countOfMatchingLotto);
        }
    }
}
