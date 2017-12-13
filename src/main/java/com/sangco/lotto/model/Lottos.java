package com.sangco.lotto.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sangco.lotto.Match;

public class Lottos {
	private ArrayList<Lotto> lottoArray = new ArrayList<>();
	private WinLottoState winLottoState;
	private int buyInPerson = 0;

	public Lottos(int howMany, ArrayList<String> pickInPerson) throws Exception {
		winLottoState = WinLottoState.getInstance();

		for (String string : pickInPerson) {
			lottoArray.add(new UserLotto(winNumbValidation(string).split(",")));
		}
		buyInPerson = howMany - pickInPerson.size();
		for (int i = 0; i < buyInPerson; i++) {
			lottoArray.add(new UserLotto());
		}
	}

	public void doMatchEachLotto(ArrayList<String> winNumb, int bonus) throws Exception {
		Map<Match, Integer> winData = getWinDataMap();
		for (Lotto lotto : lottoArray) {
			Match match = lotto.findWinMatch(winNumb, bonus);
			Integer count = winData.get(match);
			winData.put(match, (count == null) ? 1 : count + 1);
		}
		winLottoState.setWinData(winData);
	}

	private Map<Match, Integer> getWinDataMap() {
		Map<Match, Integer> winData = new HashMap<>();
		Match[] values = Match.values();
		for (Match match : values) {
			winData.put(match, 0);
		}
		return winData;
	}

	public ArrayList<Lotto> getLottoArray() {
		return lottoArray;
	}

	public WinLottoState findWin() {
		return winLottoState;
	}

	public int getBuyInperson() {
		return buyInPerson;
	}
	
	private String winNumbValidation(String string) throws Exception {
		if(!(1 <= Integer.parseInt(string) & Integer.parseInt(string) <= 45)) {
			throw new Exception();
		}
		return string;
	}
}
