package model;

import java.util.*;

public class LottoGame {

	private static final int PRICE = 1000;

	private NaturalNumber money;
	private List<UserLotto> lottos;
	private Map<ResultTypes, Integer> gameResults;

	public LottoGame(NaturalNumber money) {
		gameResults = new HashMap<>();
		this.money = money;
		NaturalNumber playableCount = new NaturalNumber(money.getNumber() / PRICE);
		this.lottos = playAutoGames(playableCount.getNumber());
	}

	public LottoGame(NaturalNumber money, List<List<Integer>> manualLottoNumbers)
				throws IllegalArgumentException {
		gameResults = new HashMap<>();

		this.money = money;

		NaturalNumber playableCount = new NaturalNumber(money.getNumber() / PRICE);
		NaturalNumber manualGameCount = new NaturalNumber(manualLottoNumbers.size());

		if(playableCount.isLessThan(manualGameCount))
			throw new IllegalArgumentException("Not enough money.");

		List<UserLotto> manualGames = playManualGames(manualLottoNumbers);
		List<UserLotto> autoGames = playAutoGames(
				playableCount.getNumber() - manualGameCount.getNumber());

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

	private List<UserLotto> playManualGames(List<List<Integer>> manualLottoNumbers) throws IllegalArgumentException {
		List<UserLotto> lottos = new ArrayList<>();

		for (List<Integer> lottoNumber : manualLottoNumbers) {
			lottos.add(new UserLotto(lottoNumber));
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

		return (prizeSum * 100) / money.getNumber();
	}

	public List<UserLotto> getLottos() {
		return lottos;
	}
}