package com.sangco.lotto.model;

public class UserLotto extends Lotto {
	public UserLotto(String[] pickInPerson) {
		for (String string : pickInPerson) {
			setPickedNumb(Integer.parseInt(string));
		}
		doSort();
	}
}
