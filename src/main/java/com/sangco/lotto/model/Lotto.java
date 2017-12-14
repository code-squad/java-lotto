package com.sangco.lotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
	protected List<Integer> pickedNumb = new ArrayList<>();

	public Match findWinMatch(ArrayList<String> winNumb, int bonus) {
		boolean isBonus = false;
		isBonus = machBonus(bonus);
		int matchLotto = 0;
		for (String string : winNumb) {
			matchLotto += matchNumb(Integer.parseInt(string));
		}
		return Match.valueOf(matchLotto, isBonus);
	}

	private int matchNumb(int numb) {
		return pickedNumb.contains(numb) ? 1 : 0;
	}

	private boolean machBonus(int bonus) {
		return pickedNumb.contains(bonus) ? true : false;
	}

	public List<Integer> getPickedNumb() {
		return pickedNumb;
	}
}
