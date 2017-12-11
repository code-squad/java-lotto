package com.sangco.lotto.model;

import java.util.ArrayList;
import java.util.Collections;

public class Lotto {
	private ArrayList<Integer> pickedNumb = new ArrayList<>();
	private int matchLotto = 0;
	private boolean isBonus = false;

	public void findWinOrNot(String winNumb, int bonus) {
		for (String string : winNumb.split(",")) {
			machNumb(Integer.parseInt(string));
		}
		machBonus(bonus);
	}

	private void machNumb(int numb) {
		if (pickedNumb.contains(numb)) {
			matchLotto++;
		}
	}

	private void machBonus(int bonus) {
		if (pickedNumb.contains(bonus)) {
			isBonus = true;
		}
	}

	public ArrayList<Integer> getPickedNumb() {
		return pickedNumb;
	}

	public void setPickedNumb(int numb) {
		this.pickedNumb.add(numb);
	}

	public int getMatchLotto() {
		return matchLotto;
	}

	public boolean isBonus() {
		return isBonus;
	}

	public void doSort() {
		Collections.sort(this.pickedNumb);
	}
}
