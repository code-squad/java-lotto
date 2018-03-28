package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoProcess {
	private ArrayList<Lotto> lottos;

	public LottoProcess(ArrayList<Lotto> lottos) {
		this.lottos = lottos;
	}

	public static LottoProcess of(int sheets) {
		ArrayList<Lotto> lottos = new ArrayList<>();
		for (int i = 0; i < sheets; i++) {
			lottos.add(Lotto.of());
		}
		return new LottoProcess(lottos);
	}

	public int size() {
		return lottos.size();
	}

	public String getNumber(int i) {
		return getLotto(i).Number();
	}

	public Lotto getLotto(int i) {
		return lottos.get(i);
	}

	public int countOfMatch(int i, List<String> beforeWinNumber) {
		return getLotto(i).countOfMatch(beforeWinNumber);
	}

}
