package lotto;

import java.util.ArrayList;

import java.util.HashMap;

public class Lottos {
	private ArrayList<MyLotto> lottos = new ArrayList<>();

	Lottos(int num) {
		for (int i = 0; i < num; i++) {
			lottos.add(new MyLotto(num));
		}
	}

	public int getBuyNum() {
		return this.lottos.size();
	}

	public MyLotto getLottos(int index) {
		return lottos.get(index);
	}

	public HashMap<Match, Integer> compareLotto(WinningLotto winLotto) {
		HashMap<Match, Integer> result = new HashMap<>();
		initMap(result);
		for (MyLotto myLotto : lottos)
			result = makeStatics(result, myLotto.compareNum(winLotto));
		return result;
	}

	private HashMap<Match, Integer> makeStatics(HashMap<Match, Integer> result, Match match) {
		if (result.get(match) != null)
			result.put(match, result.get(match) + 1);
		return result;
	}

	private void initMap(HashMap<Match, Integer> map) {
		map.put(Match.MATCH_FOURTH, 0);
		map.put(Match.MATCH_THIRD, 0);
		map.put(Match.MATCH_SECOND, 0);
		map.put(Match.MATCH_FIRST, 0);
		map.put(Match.MATCH_BONUS, 0);
	}

}
