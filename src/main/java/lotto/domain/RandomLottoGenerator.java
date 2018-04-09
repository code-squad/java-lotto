package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomLottoGenerator implements LottoGenerator {
	private static final int LOTTO_NUMBERS_SIZE = 6;
	private static Numbers lottoNumbersSet = new Numbers(IntStream.rangeClosed(1, 45).toArray());

	@Override
	public List<Lotto> generate(int number) {
		return IntStream.range(0, number)
				.mapToObj(n -> new Lotto(getSortedRandomNumbers()))
				.collect(Collectors.toList());
	}

	private Numbers getSortedRandomNumbers() {
		return lottoNumbersSet.shuffle().subNumbers(0, LOTTO_NUMBERS_SIZE).sort();
	}
}
