package lotto.domain;

import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class RandomLottoGenerator implements LottoGenerator {
	private static final int LOTTO_NUMBERS_SIZE = 6;
	private static LottoNumbers lottoNumbersSet = new LottoNumbers(IntStream.rangeClosed(LottoNumber.MIN_NUMBER, LottoNumber.MAX_NUMBER)
			.mapToObj(LottoNumber::new)
			.collect(toList()));

	@Override
	public List<Lotto> generate(int number) {
		return IntStream.range(0, number)
				.mapToObj(n -> new Lotto(getSortedRandomNumbers()))
				.collect(toList());
	}

	private LottoNumbers getSortedRandomNumbers() {
		return lottoNumbersSet.shuffle().subNumbers(0, LOTTO_NUMBERS_SIZE).sort();
	}
}
