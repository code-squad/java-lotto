package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
	private List<Lotto> lottos = null;

	public Lottos() {
		lottos = new ArrayList<>();
	}

	public void purchasePrice(int price) {
		for (int i = 0; i < price / 1000; i++) {
			lottos.add(new NomalLotto());
		}
	}
	
	public void addLotto(String lottoString) {
		lottos.add(new NomalLotto(lottoString));
	}

	public int size() {
		return lottos.size();
	}

	public String getString(int i) {
		return getLotto(i).getString();
	}

	public Lotto getLotto(int index) {
		return lottos.get(index);
	}
}
