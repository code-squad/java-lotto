import java.util.ArrayList;
import java.util.List;

public class Lottos {
	
	List<Lotto> lottos;
	
	Lottos(List<Lotto> lottos) {
		this.lottos = lottos;
	}

	List<Match> createMatches(List<Integer> luckyNumbers, int bonusNumber) {
		List<Match> matches = new ArrayList<>();
		for (Lotto eachLotto : this.lottos) {
			int matchingCount = eachLotto.makeMatchingCount(luckyNumbers);
			boolean bonusTag = eachLotto.makeMatchingBonusTag(luckyNumbers, bonusNumber);
			Match match = Match.findMatch(matchingCount, bonusTag);
			if (match != null) {
				matches.add(match);				
			}
		}
		return matches;
	}	
}
