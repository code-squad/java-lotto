package com.sangco.lotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.sangco.lotto.Match;

public class Lotto {
	protected List<Integer> pickedNumb = new ArrayList<>();

	public Match findWinMatch(ArrayList<String> winNumb, int bonus) throws Exception {
		boolean isBonus = false;
		isBonus = machBonus(bonus);
		int matchLotto = 0;
		for (String string : winNumb) {
			matchLotto += matchNumb(winNumbValidation(string));
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
		return pickedNumb.contains(bonus) ? true : false;
	}

	public List<Integer> getPickedNumb() {
		return pickedNumb;
	}
	
	private int winNumbValidation(String string) throws Exception {
		int numb = 0;
		if(!(1 <= Integer.parseInt(string) & Integer.parseInt(string) <= 45)) {
			throw new Exception();
		}
		return Integer.parseInt(string);
	}
}
