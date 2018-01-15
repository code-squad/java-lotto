package lotto.domain.lottogenerator;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static lotto.util.LottoUtils.LOTTO_MAX_COUNT;
import static lotto.util.LottoUtils.LOTTO_MAX_NUMBER;
import static lotto.util.LottoUtils.LOTTO_MIN_NUMBER;

public class RandomLottoNumberGenerator implements LottoNumberGenerator {

    @Override
    public List<Integer> generate() {
        List<Integer> lottoNumbers = IntStream.range(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER).boxed().collect(Collectors.toList());
        Collections.shuffle(lottoNumbers);
        return lottoNumbers.stream().limit(LOTTO_MAX_COUNT).sorted().collect(Collectors.toList());
    }
}
