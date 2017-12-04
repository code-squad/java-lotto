import java.util.ArrayList;
import java.util.List;

public class Lottos {
	
	List<Lotto> lottos;
	
	Lottos(List<Lotto> lottos) {
		this.lottos = lottos;
	}

	List<Match> createMatches(List<Integer> winningLotto, int bonusNumber) {
		List<Match> matches = new ArrayList<>();
		for (Lotto eachLotto : this.lottos) {
			int matchingCount = eachLotto.makeMatchingCount(winningLotto);
			boolean bonusTag = eachLotto.makeMatchingBonusTag(bonusNumber);
			Match match = Match.findMatch(matchingCount, bonusTag);
			if (match != null) {
				matches.add(match);				
			}
		}
		return matches;
	}	
}
