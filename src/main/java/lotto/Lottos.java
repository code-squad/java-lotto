package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class Lottos {
	private ArrayList<MyLotto> lottos = new ArrayList<>();
	private static final int CORRECT_THREE = 3;
	private static final int CORRECT_FOUR = 4;
	private static final int CORRECT_FIVE = 5;
	private static final int CORRECT_SIX = 6;

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

	public HashMap<Integer, Integer> compareLotto(ArrayList<Integer> prizeNum) {
		HashMap<Integer, Integer> result = new HashMap<>();
		initMap(result);
		for (int i = 0; i < lottos.size(); i++) {
			int sameNum = compareNum(prizeNum, getLottos(i));
			result = makeStatics(result, sameNum);
		}
		return result;
	}

	public int compareNum(ArrayList<Integer> prizeNum, MyLotto myLotto) {
		int sameNum = 0;
		for (int num : myLotto.getMyLotto()) {
			if (prizeNum.contains(num))
				sameNum++;
		}
		return sameNum;
	}

	private HashMap<Integer, Integer> makeStatics(HashMap<Integer, Integer> result, int sameNum) {
		if (result.keySet().contains(sameNum)) {
			result.put(sameNum, result.get(sameNum) + 1);
		}
		return result;
	}

	private void initMap(HashMap<Integer, Integer> map) {
		map.put(CORRECT_THREE, 0);
		map.put(CORRECT_FOUR, 0);
		map.put(CORRECT_FIVE, 0);
		map.put(CORRECT_SIX, 0);
	}

	public void sortLottos() {
		for (int i = 0; i < lottos.size(); i++)
			Collections.sort(getLottos(i).getMyLotto());
	}
}
