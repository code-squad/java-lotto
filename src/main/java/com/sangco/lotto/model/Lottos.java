package com.sangco.lotto.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sangco.lotto.Match;

public class Lottos {
	private ArrayList<Lotto> lottoArray = new ArrayList<>();
	private WinLottoState winLottoState;
	private int buyInPerson = 0;

	public Lottos(int howMany, ArrayList<String> pickInPerson) {
		winLottoState = WinLottoState.getInstance();

		for (String string : pickInPerson) {
			lottoArray.add(new UserLotto(string.split(",")));
		}
		buyInPerson = howMany - pickInPerson.size();
		for (int i = 0; i < buyInPerson; i++) {
			lottoArray.add(new UserLotto());
		}
	}

	public ArrayList<Lotto> getLottoArray() {
		return lottoArray;
	}

	public void doMatchEachLotto(String winNumb, int bonus) {
		Map<Match, Integer> winData = new HashMap<>();
		for (Lotto lotto : lottoArray) {
			if (lotto.findWinMatch(winNumb, bonus) != null) {
				Match match = lotto.findWinMatch(winNumb, bonus);
				Integer count = winData.get(match);
				winData.put(match, (count == null) ? 1 : count + 1);
			}

		}
		winLottoState.setWinData(winData);
	}

	public WinLottoState findWin() {
		return winLottoState;
	}

	public int getBuyInperson() {
		return buyInPerson;
	}
}
