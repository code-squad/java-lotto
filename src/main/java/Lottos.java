import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Lottos {
	private static final Logger log = LoggerFactory.getLogger(Main.class);
	
	private List<UserLotto> lottos;
	private int lottosSize;
	
	public Lottos(List<UserLotto> lottos) {
		this.lottos = lottos;
		this.lottosSize = lottos.size();
	}
	
	public List<UserLotto> getLottos() {
		return this.lottos;
	}
	
	public int getLottosSize() {
		return this.lottosSize;
	}

	List<Match> createMatches(List<Integer> winningLotto, int bonusNumber) {
		List<Match> matches = new ArrayList<>();
		for (UserLotto eachLotto : this.lottos) {
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
