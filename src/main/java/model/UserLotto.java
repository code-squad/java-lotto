package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class UserLotto extends Lotto {

	private List<Integer> numbers;

	public UserLotto(List<Integer> list) {
		this.numbers = list;
	}

	public static UserLotto initLotto() {
		List<Integer> list = new ArrayList<>();
		List<Integer> range = IntStream.range(1, 45).boxed().collect(Collectors.toList());
		Collections.shuffle(range);
		for(int i=0; i < 6; i++) {
			list.add(range.get(i));
		}
		Collections.sort(list);
		return new UserLotto(list);
	}
}
