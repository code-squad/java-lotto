package com.sangco.lotto.model;

import java.util.ArrayList;
import java.util.Collections;

public class AutoLotto extends Lotto {
	public AutoLotto() {
		ArrayList<Integer> lottoNumb = makeBallAndSuffle();
		for (int i = 0; i < 6; i++) {
			setPickedNumb(lottoNumb.get(i));
		}
		doSort();
	}

	public ArrayList<Integer> makeBallAndSuffle() {
		ArrayList<Integer> lottoNumb = new ArrayList<>();
		for (int i = 1; i <= 45; i++)
			lottoNumb.add(i);
		Collections.shuffle(lottoNumb);
		return lottoNumb;
	}
}
