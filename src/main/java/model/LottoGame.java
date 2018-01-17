package model;

import model.gameResult.GameResult;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

	public List<GameResult> runGames() {
		Map<Object, Integer> gameResults = new HashMap<>();

		for(Lotto lotto : lottos) {
			int matchCount = lotto.compare(winningLotto);
			int winningPrice = ResultTypes.findByCode(matchCount).getPrice();
			System.out.println(winningPrice);

		}

		return null;
	}

	public List<Lotto> getLottos() {
		return lottos;
	}

	public void setWinningLotto(Lotto winningLotto) {
		this.winningLotto = winningLotto;
	}

}