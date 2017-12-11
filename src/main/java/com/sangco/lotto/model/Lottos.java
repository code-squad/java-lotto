package com.sangco.lotto.model;


import java.util.ArrayList;

import com.sangco.lotto.Match;

public class Lottos {
	private ArrayList<Lotto> lottoArray = new ArrayList<>();
	private WinLottoState winLottoState;
	private int buyInPerson = 0;
	private int totalPrizeMoney = 0;

	public Lottos(int howMany, ArrayList<String> pickInPerson) {
		winLottoState = WinLottoState.getInstance();

		for (String string : pickInPerson) {
			lottoArray.add(new UserLotto(string.split(",")));
		}
		buyInPerson = howMany - pickInPerson.size();
		for (int i = 0; i < buyInPerson; i++) {
			lottoArray.add(new AutoLotto());
		}
	}

	public ArrayList<Lotto> getLottoArray() {
		return lottoArray;
	}

	public void doMatchEachLotto(String winNumb, int bonus) {
		for (int i = 0; i < lottoArray.size(); i++) {
			lottoArray.get(i).findWinOrNot(winNumb, bonus);
			winLottoState.countWin(lottoArray.get(i).getMatchLotto(), lottoArray.get(i).isBonus());
		}
	}

	public WinLottoState findWin() {
		return winLottoState;
	}

	public int getBuyInperson() {
		return buyInPerson;
	}

	public long findLottoRateOfProfit() {
		long total = 0;
		total += Match.valueOf(3).getWinningMoney() * winLottoState.getWinnerData(3, false);
		total += Match.valueOf(4).getWinningMoney() * winLottoState.getWinnerData(4, false);
		total += Match.valueOf(5).getWinningMoney() * winLottoState.getWinnerData(5, false);
		total += Match.valueOf(6).getWinningMoney() * winLottoState.getWinnerData(6, false);
		total += Match.valueOf(7).getWinningMoney() * winLottoState.getWinnerData(5, true);
		return total;
	}
}
