package com.sangco.lotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class WinLottoState {
	private static WinLottoState list;
	private Map<Match, Integer> winData;

	public static WinLottoState getInstance() {
		if (list == null) {
			list = new WinLottoState();
		}
		return list;
	}

	public long findLottoRateOfProfit() {
		long total = 0;

		for (Match match : Match.values()) {
			total += match.getWinningMoney(winData.get(match));
		}
		return total;
	}

	public void setWinData(Map<Match, Integer> data) {
		winData = data;
	}
	
	public int getMatchCount(Match match) {
		return winData.get(match);
	}
	
	public Map<Match, Integer> getWinDataMap() {
		Match[] values = Match.values();
		for (Match match : values) {
			winData.put(match, 0);
		}
		return winData;
	}
	
	public void matchWindataWithUserLotto(Match match) {
		Integer count = winData.get(match);
		winData.put(match, (count == null) ? 1 : count + 1);
	}
}
