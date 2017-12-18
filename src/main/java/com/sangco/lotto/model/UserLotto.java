package com.sangco.lotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UserLotto extends Lotto {
	public UserLotto() {
		ArrayList<Integer> lottoNumb = createRandomLotto();
		pickedNumb = lottoNumb.subList(0, 6);
		doSort(pickedNumb);
	}

	public UserLotto(String[] pickInPerson) {
		pickedNumb = new ArrayList<>();
		for (String string : pickInPerson) {
			pickedNumb.add(Integer.parseInt(string));
		}
		doSort(pickedNumb);
	}

	public ArrayList<Integer> createRandomLotto() {
		ArrayList<Integer> lottoNumb = new ArrayList<>();
		for (int i = 1; i <= 45; i++)
			lottoNumb.add(i);
		Collections.shuffle(lottoNumb);
		return lottoNumb;
	}

	public void doSort(List<Integer> pickedNumb) {
		Collections.sort(pickedNumb);
	}
}
