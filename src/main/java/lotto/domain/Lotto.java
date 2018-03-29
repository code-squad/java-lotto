package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
	private List<Integer> numbers;
	public static final int LOTTO_SIZE = 6;

	public Lotto(List<Integer> numbers) {
		this.numbers = numbers;
	}

	public static Lotto of(List<Integer> numberRange) {
		Collections.shuffle(numberRange);
		return new Lotto(makeLottoNum(numberRange));
	}

	public static Lotto ofValue(List<String> initnumbers) {
		ArrayList<Integer> numbers = new ArrayList<>();
		for (int i = 0; i < initnumbers.size(); i++) {
			numbers.add(Integer.parseInt(initnumbers.get(i).trim()));
		}
		return new Lotto(numbers);
	}

	public static List<Integer> makeLottoNum(List<Integer> temp) {
		List<Integer> numbers = new ArrayList<>();
		for (int i = 0; i < LOTTO_SIZE; i++) {
			numbers.add(temp.get(i));
		}
		Collections.sort(numbers);
		return numbers;
	}

	public String numbers() {
		return numbers.toString();
	}

	public int countOfMatch(Lotto beforeWinLotto) {
		int countOfMatch = 0;
		for (Integer no : numbers) {
			countOfMatch += beforeWinLotto.countOfMatch(no);
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

}
