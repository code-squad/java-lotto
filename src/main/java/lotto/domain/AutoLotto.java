package lotto.domain;

import java.util.Collections;
import java.util.List;

public class AutoLotto extends Lotto {

	public AutoLotto(List<Integer> numbers) {
		super(numbers);
	}

	public static AutoLotto of(List<Integer> numberRange) {
		Collections.shuffle(numberRange);
		return new AutoLotto(makeLottoNum(numberRange));
	}
}
