package lotto;

import java.util.ArrayList;
import static lotto.Rank.RANK_FIRST;
import static lotto.Rank.RANK_SECOND;
import static lotto.Rank.RANK_THIRD;
import static lotto.Rank.RANK_FOURTH;
import static lotto.Rank.RANK_BONUS;

import java.util.HashMap;
import java.util.Map;

public class Lottos {
	private ArrayList<MyLotto> lottos = new ArrayList<>();
	private int userLottoNum;
	HashMap<Rank, Integer> result = new HashMap<>();

	Lottos(ArrayList<MyLotto> userLottos, int lottoNum) {
		this.userLottoNum = userLottos.size();
		int autoLottoNum = lottoNum - userLottos.size();
		for (int index = 0; index < userLottos.size(); index++){
			lottos.add(userLottos.get(index));
		}
		for (int i = 0; i < autoLottoNum; i++)
			lottos.add(new MyLotto(autoLottoNum));

	}
	public ArrayList<MyLotto> getLottos() {
		return lottos;
	}

	public int getBuyNum() {
		return this.lottos.size();
	}

	public int getUserNum() {
		return this.userLottoNum;
	}
	

	public MyLotto getLotto(int index) {
		return lottos.get(index);
	}

	public HashMap<Rank, Integer> compareLotto(WinningLotto winLotto) {
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
	
	public int getFourth() {
		return result.get(RANK_FOURTH);
	}
	public int getThird() {
		return result.get(RANK_THIRD);
	}
	public int getSecond() {
		return result.get(RANK_SECOND);
	}
	public int getFirst() {
		return result.get(RANK_FIRST);
	}
	public int getBonus() {
		return result.get(RANK_BONUS);
	}
	

}
