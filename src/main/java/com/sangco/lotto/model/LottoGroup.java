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
		Map<Match, Integer> winData = winLottoState.getWinDataMap();
		for (Lotto lotto : lottoList) {
			Match match = lotto.findWinMatch(winNumberList, bonus);
			winLottoState.matchWindataWithUserLotto(match);
		}
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
