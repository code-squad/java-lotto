package com.sangco.lotto.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoGroup {
	private ArrayList<Lotto> lottoList = new ArrayList<>();
	private WinLottoState winLottoState;
	private int lottoBuyInPerson = 0;

	public LottoGroup(int purchasedLotto, ArrayList<String> selectedlotto) {
		winLottoState = WinLottoState.getInstance();

		for (String eachSelectedLotto : selectedlotto) {
			lottoList.add(new UserLotto(eachSelectedLotto.split(",")));
		}

		lottoBuyInPerson = purchasedLotto - lottoList.size();
		for (int i = 0; i < lottoBuyInPerson; i++) {
			lottoList.add(new UserLotto());
		}
	}

	public void doMatchEachLotto(ArrayList<String> winNumberList, int bonus) {
		Map<Match, Integer> winData = getWinDataMap();
		for (Lotto lotto : lottoList) {
			Match match = lotto.findWinMatch(winNumberList, bonus);
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
		return lottoList;
	}

	public WinLottoState getWinLottoState() {
		return winLottoState;
	}

	public int getBuyInperson() {
		return lottoBuyInPerson;
	}

	public ArrayList<String> getEachLottoNumber() {
		ArrayList<String> lottoNumberList = new ArrayList<>();
		for (Lotto lotto : lottoList) {
			lottoNumberList.add(lotto.getPickedNumb().toString());
		}
		return lottoNumberList;
	}
}
