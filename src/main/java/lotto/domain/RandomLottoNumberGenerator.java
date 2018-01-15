package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomLottoNumberGenerator implements LottoNumberGenerator {

    @Override
    public int[] generate() {
        List<Integer> lottoNumbers = IntStream.range(1, 45).boxed().collect(Collectors.toList());
        Collections.shuffle(lottoNumbers);
        return lottoNumbers.stream().mapToInt(i->i).limit(6).sorted().toArray();
    }
}
