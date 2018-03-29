package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class UserLotto extends Lotto {

	public UserLotto(List<Integer> numbers) {
		this.numbers = numbers;
	}

	public static UserLotto of(List<String> initnumbers) {
		ArrayList<Integer> numbers = new ArrayList<>();
		for (int i = 0; i < initnumbers.size(); i++) {
			numbers.add(Integer.parseInt(initnumbers.get(i).trim()));
		}
		return new UserLotto(numbers);
	}

}
