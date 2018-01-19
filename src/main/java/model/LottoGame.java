package model;

import java.util.*;
import java.util.stream.Collectors;

public class LottoGame {

	private static final int PRICE = 1000;

	private int money;
	private List<UserLotto> lottos;
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

		List<UserLotto> manualGames = playManualGames(manualLottoNumbers);
		List<UserLotto> autoGames = playAutoGames(playableCount - manualGameCount);

		this.lottos = new ArrayList<>();
		this.lottos.addAll(manualGames);
		this.lottos.addAll(autoGames);
	}

	private List<UserLotto> playAutoGames(int count) {
		List<UserLotto> lottos = new ArrayList<>();

		for (int i = 0; i < count; i++) {
			lottos.add(new UserLotto());
		}

		return lottos;
	}

	private List<UserLotto> playManualGames(List<List<Integer>> manualLottoNumbers) {
		List<UserLotto> lottos = new ArrayList<>();

		for (List<Integer> lottoNumber : manualLottoNumbers) {
			lottos.add(new UserLotto(
					lottoNumber.stream()
					.map(LottoNumber::new)
					.collect(Collectors.toList())));
		}

		return lottos;
	}

	public Map<ResultTypes, Integer> runGames(WinningLotto winningLotto) {
		for(UserLotto lotto : lottos) {
			ResultTypes key = winningLotto.compare(lotto);

			if (!gameResults.containsKey(key)) {
				gameResults.put(key, 1);
				continue;
			}

			gameResults.put(key, gameResults.get(key) + 1);
		}

		return gameResults;
	}

	public long getYieldRate() {
		long prizeSum = 0;

		for(ResultTypes type : gameResults.keySet()) {
			prizeSum += type.calculatePrize(gameResults.get(type));
		}

		return (prizeSum * 100) / money;
	}

	public List<UserLotto> getLottos() {
		return lottos;
	}
}