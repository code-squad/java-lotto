package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class UserLotto extends Lotto {

	public UserLotto(List<Integer> numbers) {
		super(numbers);
	}

	public static UserLotto of(List<String> initnumbers) {
		ArrayList<Integer> numbers = new ArrayList<>();
		for (int i = 0; i < initnumbers.size(); i++) {
			numbers.add(Integer.parseInt(initnumbers.get(i).trim()));
		}
		return new UserLotto(numbers);
	}

	public static void check(List<String> userNum) {
		System.out.println(userNum.size());
		for (int i = 0; i < userNum.size(); i++) {
			check(userNum, i);
		}
	}

	public static void check(List<String> userNum, int i) {
		if (Integer.parseInt(userNum.get(i)) <= 0 || Integer.parseInt(userNum.get(i)) > 45) {
			throw new IllegalArgumentException("0~45범위초과");
		}
		if (i < userNum.size() - 1 && userNum.get(i).equals(userNum.get(i + 1))) {
			throw new IllegalArgumentException();
		}
		if (userNum.size() > 6) {
			throw new IndexOutOfBoundsException();
		}
	}

}
