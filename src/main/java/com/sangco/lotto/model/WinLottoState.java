package com.sangco.lotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.sangco.lotto.Match;

public class WinLottoState {
	private static WinLottoState list;
	private Map<Match, Integer> winData;

	public static WinLottoState getInstance() {
		if (list == null) {
			list = new WinLottoState();
		}
		return list;
	}

	public Integer getEachWinNumb(int numb, boolean isBonus) {
		if (winData.keySet() != null) {
			Iterator<Match> iter = winData.keySet().iterator();
			while (iter.hasNext()) {
				Match match = (Match) iter.next();
				if (match.getCountOfMatch() == numb & match.isBonus() == isBonus) {
					return winData.get(match);
				}
			}
		}
		return 0;
	}

	public long findLottoRateOfProfit() {
		long total = 0;
		total += Match.valueOf(3, false).getWinningMoney() * getEachWinNumb(3, false);
		total += Match.valueOf(4, false).getWinningMoney() * getEachWinNumb(4, false);
		total += Match.valueOf(5, false).getWinningMoney() * getEachWinNumb(5, false);
		total += Match.valueOf(5, true).getWinningMoney() * getEachWinNumb(5, true);
		total += Match.valueOf(6, false).getWinningMoney() * getEachWinNumb(6, false);
		return total;
	}

	public void setWinData(Map<Match, Integer> data) {
		winData = data;
	}

	public Map<Match, Integer> getWinData() {
		return winData;
	}
}
