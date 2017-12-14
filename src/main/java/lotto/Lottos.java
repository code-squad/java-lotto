package lotto;

import java.util.ArrayList;
import static lotto.Rank.RANK_FIRST;
import static lotto.Rank.RANK_SECOND;
import static lotto.Rank.RANK_THIRD;
import static lotto.Rank.RANK_FOURTH;
import static lotto.Rank.RANK_BONUS;

import java.util.HashMap;

public class Lottos {
	private ArrayList<MyLotto> lottos = new ArrayList<>();
	private int userLottoNum;

	Lottos(ArrayList<Integer> userLottos, int lottoNum) {
		this.userLottoNum = userLottos.size()/ 6;
		int autoLottoNum = lottoNum - userLottoNum;
		for (int i = 0; i < userLottos.size();){
			lottos.add(new MyLotto(userLottos, i));
			i += 6;
		}
		for (int i = 0; i < autoLottoNum; i++)
			lottos.add(new MyLotto(autoLottoNum));

	}

	public int getBuyNum() {
		return this.lottos.size();
	}

	public int getUserNum() {
		return this.userLottoNum;
	}

	public MyLotto getLottos(int index) {
		return lottos.get(index);
	}

	public HashMap<Rank, Integer> compareLotto(WinningLotto winLotto) {
		HashMap<Rank, Integer> result = new HashMap<>();
		initMap(result);
		for (MyLotto myLotto : lottos)
			result = makeStatics(result, myLotto.compareNum(winLotto));
		return result;
	}

	private HashMap<Rank, Integer> makeStatics(HashMap<Rank, Integer> result, Rank rank) {
		if (result.get(rank) != null)
			result.put(rank, result.get(rank) + 1);
		return result;
	}

	private void initMap(HashMap<Rank, Integer> map) {
		map.put(RANK_FOURTH, 0);
		map.put(RANK_THIRD, 0);
		map.put(RANK_SECOND, 0);
		map.put(RANK_FIRST, 0);
		map.put(RANK_BONUS, 0);
	}

}
