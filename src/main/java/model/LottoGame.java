package model;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoGame {

	private static final int PRICE = 1000;

	private NaturalNumber money;
	private List<Lotto> lottos;
	private Map<ResultTypes, Integer> gameResults;

	public LottoGame(NaturalNumber money) {
		gameResults = new HashMap<>();
		this.money = money;
		NaturalNumber playableCount = new NaturalNumber(money.getNumber() / PRICE);
		this.lottos = playAutoGames(playableCount.getNumber());
	}

	public LottoGame(NaturalNumber money, List<String> manualLottoNumbers)
				throws IllegalArgumentException {
		gameResults = new HashMap<>();

		this.money = money;

		NaturalNumber playableCount = new NaturalNumber(money.getNumber() / PRICE);
		NaturalNumber manualGameCount = new NaturalNumber(manualLottoNumbers.size());

		if(playableCount.isLessThan(manualGameCount))
			throw new IllegalArgumentException("Not enough money.");

		List<Lotto> manualGames = playManualGames(manualLottoNumbers);
		List<Lotto> autoGames = playAutoGames(
				playableCount.getNumber() - manualGameCount.getNumber());

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

	private List<Lotto> playManualGames(List<String> manualLottoNumbers) throws IllegalArgumentException {
		List<Lotto> lottos = new ArrayList<>();

		for (String lottoNumber : manualLottoNumbers) {
			lottos.add(new Lotto(lottoNumber.split(",")));
		}

		return lottos;
	}

	public Map<ResultTypes, Integer> runGames(String[] winningNumbers, int bonus) {
		WinningLotto winningLotto = new WinningLotto(new Lotto(winningNumbers), bonus);

		for(Lotto lotto : lottos) {
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

	public List<Lotto> getLottos() {
		return lottos;
	}
}