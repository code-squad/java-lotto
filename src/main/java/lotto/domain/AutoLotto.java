package lotto.domain;

import java.util.Collections;
import java.util.List;

public class AutoLotto extends Lotto {

	public AutoLotto(List<Integer> numbers) {
		super(numbers);
	}

	public AutoLotto(List<Integer> numbers, int sheets) {
		super(numbers,sheets);
	}

	public static AutoLotto of(List<Integer> numberRange) {
		Collections.shuffle(numberRange);
		return new AutoLotto(makeLottoNum(numberRange));
	}
	public static AutoLotto ofWinLotto(List<Integer> numberRange, int sheets) {
		Collections.shuffle(numberRange);
		return new AutoLotto(makeWinLottoNum(numberRange),sheets);
	}
}
