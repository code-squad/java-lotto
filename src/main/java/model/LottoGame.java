package model;

import java.util.*;
import java.util.stream.Collectors;

public class LottoGame {

	private final int PRICE = 1000;
	private final int BOUND = 46;
	private final int SIZE = 6;

	private List<Lotto> lottos;
	private Lotto winningLotto;

	public LottoGame(int money) {
		this.lottos = playAutoGames(money / PRICE);
	}

	public LottoGame(int money, List<Integer>[] manualLottoNumbers) {
		int playableCount = money / PRICE;
		int manualGameCount = manualLottoNumbers.length;

		List<Lotto> manualGames = playManualGames(manualGameCount, manualLottoNumbers);
		List<Lotto> autoGames = playAutoGames(playableCount - manualGameCount);

		this.lottos = new ArrayList<>();
		this.lottos.addAll(manualGames);
		this.lottos.addAll(autoGames);
	}

	private List<Lotto> playAutoGames(int count) {
		List<Lotto> lottos = new ArrayList<>();

		for (int i = 0; i < count; i++) {
			lottos.add(new Lotto(BOUND, SIZE));
		}

		return lottos;
	}

	private List<Lotto> playManualGames(int count, List<Integer>[] manualLottoNumbers) {
		List<Lotto> lottos = new ArrayList<>();

		for (int i = 0; i < count; i++) {
			lottos.add(new Lotto(BOUND, SIZE, manualLottoNumbers[i]));
		}

		return lottos;
	}

	public Map<ResultTypes, Integer> runGames() {
		Map<ResultTypes, Integer> gameResults = new HashMap<>();

		for(Lotto lotto : lottos) {
			int matchCount = lotto.compare(winningLotto);
			ResultTypes key = ResultTypes.findByCode(matchCount);

			if (!gameResults.containsKey(key)) {
				gameResults.put(key, 1);
			} else {
				gameResults.put(key, gameResults.get(key) + 1);
			}
		}

		return gameResults;
	}

	public List<Lotto> getLottos() {
		return lottos;
	}

	public void setWinningLotto(Lotto winningLotto) {
		this.winningLotto = winningLotto;
	}

}