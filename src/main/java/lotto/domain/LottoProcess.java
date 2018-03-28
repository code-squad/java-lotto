package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoProcess {
	private List<Lotto> lottos;

	public LottoProcess(List<Lotto> lottos) {
		this.lottos = lottos;
	}

	public static LottoProcess of(int sheets) {
		List<Lotto> lottos = new ArrayList<>();
		List<Integer> numberRange = new ArrayList<>();
		for (int i = 1; i < Lotto.MAXNUM_RANGE; i++) {
			numberRange.add(i);
		}
		for (int i = 0; i < sheets; i++) {
			lottos.add(Lotto.of(numberRange));
		}
		return new LottoProcess(lottos);
	}

	public int size() {
		return lottos.size();
	}

	public String getNumber(int i) {
		return getLotto(i).numbers();
	}

	public Lotto getLotto(int i) {
		return lottos.get(i);
	}

	public int countOfMatch(int i, Lotto beforeWinLotto) {
		return getLotto(i).countOfMatch(beforeWinLotto);
	}

}
