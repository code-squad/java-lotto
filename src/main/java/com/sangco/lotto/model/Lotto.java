package com.sangco.lotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
	protected List<Integer> pickedNumb = new ArrayList<>();

	public Match findWinMatch(ArrayList<String> winNumberList, int bonus) {
		boolean isBonus = false;
		isBonus = matchBonusNumberWithLottoNumber (bonus);
		int matchLotto = 0;
		for (String eachWinNumberStr : winNumberList) {
			matchLotto += matchLottoNumber(Integer.parseInt(eachWinNumberStr));
		}
		return Match.valueOf(matchLotto, isBonus);
	}

	private int matchLottoNumber(int eachWinNumber) {
		return pickedNumb.contains(eachWinNumber) ? 1 : 0;
	}

	private boolean matchBonusNumberWithLottoNumber(int bonus) {
		return pickedNumb.contains(bonus) ? true : false;
	}

	public List<Integer> getPickedNumb() {
		return pickedNumb;
	}
}
