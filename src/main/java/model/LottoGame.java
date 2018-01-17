package model;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {

	private final int BOUND = 46;
	private final int SIZE = 6;
	private final int price;
	private List<Lotto> lottos;
	private Lotto winningLotto;

	public LottoGame(int price, int money) {
		this.price = price;
		this.lottos = playAutoGames(money / price);
	}

	public LottoGame(int price, int money, List<Integer>[] manualLottoNumbers) {
		this.price = price;
		this.lottos = playManualGames(money / price, manualLottoNumbers);
	}

	private List<Lotto> playAutoGames(int count) {
		List<Lotto> lottos = new ArrayList<>();

		for (int i = 0; i < count; i++) {
			lottos.add(new Lotto(BOUND, SIZE));
		}

		return lottos;
	}

	private List<Lotto> playManualGames(int money, List<Integer>[] manualLottoNumbers) {
		List<Lotto> lottos = new ArrayList<>();

		for (int i = 0; i < money / price; i++) {
			lottos.add(new Lotto(BOUND, SIZE, manualLottoNumbers[i]));
		}

		return lottos;
	}

	public List<Lotto> getLottos() {
		return lottos;
	}

	public void setWinningLotto(Lotto winningLotto) {
		this.winningLotto = winningLotto;
	}

}
