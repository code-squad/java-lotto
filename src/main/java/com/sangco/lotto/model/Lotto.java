package com.sangco.lotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.sangco.lotto.Match;

public class Lotto {
	public List<Integer> pickedNumb = new ArrayList<>();
	// private 안된다? 질묻드리기

	public Match findWinMatch(String winNumb, int bonus) {
		boolean isBonus = false;
		isBonus = machBonus(bonus);
		int matchLotto = 0;
		for (String string : winNumb.split(",")) {
			matchLotto += matchNumb(Integer.parseInt(string));
		}
		return Match.valueOf(matchLotto, isBonus);
	}

	private int matchNumb(int numb) {
		if (pickedNumb.contains(numb)) {
			return 1;
		}
		return 0;
	}

	private boolean machBonus(int bonus) {
		if (pickedNumb.contains(bonus)) {
			return true;
		}
		return false;
	}

	public List<Integer> getPickedNumb() {
		return pickedNumb;
	}
}
