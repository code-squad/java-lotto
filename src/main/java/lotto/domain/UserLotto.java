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
			throw new IllegalArgumentException("1~45범위의 숫자만 입력해주세요.");
		}
		if (i < userNum.size() - 1 && userNum.get(i).equals(userNum.get(i + 1))) {
			throw new IllegalArgumentException("중복되는 숫자는 입력할 수 없습니다.");
		}
		if (userNum.size() > 6) {
			throw new IndexOutOfBoundsException("6개의 숫자만 입력해주세요.");
		}
	}

}
