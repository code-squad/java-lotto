package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import lotto.view.Input;

public abstract class Lotto {
	static final int LOTTO_SIZE = 6;
	private List<Integer> numbers;

	public Lotto(List<Integer> numbers) {
		checkLength(numbers);
		LottoNo.check(numbers);
		this.numbers = numbers;
	}

	public static List<Integer> makeLottoNum(List<Integer> temp) {
		List<Integer> numbers = new ArrayList<>();
		for (int i = 0; i < LOTTO_SIZE; i++) {
			numbers.add(temp.get(i));
		}
		Collections.sort(numbers);
		return numbers;
	}

	public int countOfMatch(String beforeWinLotto) {
		int countOfMatch = 0;
		for (Integer no : numbers) {
			countOfMatch += Input.beforeWinNum(beforeWinLotto).countOfMatch(no);
		}
		return countOfMatch;
	}

	public int countOfMatch(int no) {
		if (haveNumber(no)) {
			return 1;
		}
		return 0;
	}

	public boolean haveNumber(int no) {
		return numbers.contains(no);
	}

	public static void checkLength(List<Integer> numbers) {
		if (numbers.size() != 6) {
			throw new IndexOutOfBoundsException("6개의 숫자를 입력해주세요.");
		}
		for (int i = 0; i < numbers.size() - 1; i++) {
			if (isSameNo(numbers.get(i), numbers.get(i + 1))) {
				throw new IllegalArgumentException("중복되는 숫자는 입력할 수 없습니다.");
			}
		}
	}

	public static boolean isSameNo(int number, int anotherNumber) {
		return number == anotherNumber;
	}

	public List<Integer> getNumbers() {
		return numbers;
	}

}
