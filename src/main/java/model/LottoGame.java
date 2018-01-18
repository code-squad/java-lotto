package model;

import java.util.*;
import java.util.stream.Collectors;

public class LottoGame {

	private static final int PRICE = 1000;

	private int money;
	private List<Lotto> lottos;
	private Map<ResultTypes, Integer> gameResults;

	public LottoGame(int money) {
		gameResults = new HashMap<>();
		this.money = money;
		this.lottos = playAutoGames(money / PRICE);
	}

	public LottoGame(int money, List<List<Integer>> manualLottoNumbers) {
		gameResults = new HashMap<>();

		this.money = money;

		int playableCount = money / PRICE;
		int manualGameCount = manualLottoNumbers.size();

		List<Lotto> manualGames = playManualGames(manualLottoNumbers);
		List<Lotto> autoGames = playAutoGames(playableCount - manualGameCount);

		this.lottos = new ArrayList<>();
		this.lottos.addAll(manualGames);
		this.lottos.addAll(autoGames);
	}

	private List<Lotto> playAutoGames(int count) {
		List<Lotto> lottos = new ArrayList<>();

		for (int i = 0; i < count; i++) {
			lottos.add(new Lotto());
		}

		return lottos;
	}

	private List<Lotto> playManualGames(List<List<Integer>> manualLottoNumbers) {
		List<Lotto> lottos = new ArrayList<>();

		for (List<Integer> lottoNumber : manualLottoNumbers) {
			lottos.add(new Lotto(lottoNumber));
		}

		return lottos;
	}

	public Map<ResultTypes, Integer> runGames(Lotto winningLotto) {
		for(Lotto lotto : lottos) {
			int matchCount = lotto.compare(winningLotto);
			ResultTypes key = ResultTypes.findByCode(matchCount);

			if (!gameResults.containsKey(key)) {
				gameResults.put(key, 1);
				continue;
			}

			gameResults.put(key, gameResults.get(key) + 1);
		}

		return gameResults;
	}

	public int getYieldRate() {
		int priceSum = 0;

		for(ResultTypes type : gameResults.keySet()) {
			priceSum += type.price * gameResults.get(type);
		}

		return (priceSum * 100) / money;
	}

	public List<Lotto> getLottos() {
		return lottos;
	}
}