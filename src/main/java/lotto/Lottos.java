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

	public HashMap<Integer, Integer> compareLotto(WinningLotto winLotto) {
		HashMap<Integer, Integer> result = new HashMap<>();
		initMap(result);
		for (int i = 0; i < lottos.size(); i++)
			result = makeStatics(result, lottos.get(i).compareNum(winLotto));
		return result;
	}


	private HashMap<Integer, Integer> makeStatics(HashMap<Integer, Integer> result, int sameNum) {
		if(sameNum == Match.MATCH_BONUS.getSameNum())
			result.put(Match.MATCH_BONUS.getSameNum(),  result.get(Match.MATCH_BONUS.getSameNum()) + 1);
		if (result.get(sameNum) != null && sameNum <= 6){
			result.put(sameNum, result.get(sameNum) + 1);
		}
		return result;
	}

	private void initMap(HashMap<Integer, Integer> map) {
		map.put(Match.MATCH3.getSameNum(), 0);
		map.put(Match.MATCH4.getSameNum(), 0);
		map.put(Match.MATCH5.getSameNum(), 0);
		map.put(Match.MATCH6.getSameNum(), 0);
		map.put(Match.MATCH_BONUS.getSameNum(), 0);
	}

}
