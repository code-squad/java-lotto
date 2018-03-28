package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
	private ArrayList<Integer> numbers;
	private static final int LOTTO_SIZE = 6;
	private static final int MAXNUM_RANGE = 45;

	public Lotto(ArrayList<Integer> numbers) {
		this.numbers = numbers;
	}

	public static Lotto of() {
		ArrayList<Integer> temp = new ArrayList<>();
		for (int i = 1; i < MAXNUM_RANGE; i++) {
			temp.add(i);
		}
		Collections.shuffle(temp);
		return new Lotto(makeLottoNum(temp));
	}

	public static ArrayList<Integer> makeLottoNum(ArrayList<Integer> temp) {
		ArrayList<Integer> numbers = new ArrayList<>();
		for (int i = 0; i < LOTTO_SIZE; i++) {
			numbers.add(temp.get(i));
		}
		Collections.sort(numbers);
		return numbers;
	}

	public String Number() {
		return numbers.toString();
	}

	public int countOfMatch(List<String> beforeWinNumber) {
		int countOfMatch = 0;
		for (int i = 0; i < beforeWinNumber.size(); i++) {
			countOfMatch = countOfMatch(beforeWinNumber, i, countOfMatch);
		}
		return countOfMatch;
	}

	public int countOfMatch(List<String> beforeWinNumber, int i, int countOfMatch) {
		if (numbers.contains(Integer.parseInt(beforeWinNumber.get(i)))) {
			countOfMatch++;
		}
		return countOfMatch;
	}

}
