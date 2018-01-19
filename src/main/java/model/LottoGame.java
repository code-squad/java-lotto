package model;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoGame {

	private LottoCredit credit;
	private List<Lotto> lottos;
	private LottoResult lottoResult;


	public LottoGame(LottoCredit credit) {
		this.credit = credit;
		NaturalNumber playableCount = credit.getAvailableAmount();
		this.lottos = playAutoGames(playableCount.getNumber());
		this.lottoResult = new LottoResult();
	}

	public LottoGame(LottoCredit credit, List<String> manualLottoNumbers)
				throws IllegalArgumentException {
		this.credit = credit;
		this.lottoResult = new LottoResult();

		NaturalNumber playableCount = credit.getAvailableAmount();
		NaturalNumber manualGameCount = new NaturalNumber(manualLottoNumbers.size());

		if(playableCount.isLessThan(manualGameCount))
			throw new IllegalArgumentException("Not enough credit.");

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
			lottoResult.matchLotto(winningLotto, lotto);
		}

		return lottoResult.map;
	}

	public long getYieldRate() {
		return (lottoResult.getPrize() * 100) / credit.getMoney();
	}

	public List<Lotto> getLottos() {
		return lottos;
	}
}