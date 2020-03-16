package domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static domain.Lotto.LOTTO_SIZE;
import static domain.LottoNumber.MAX_NUMBER;
import static domain.LottoNumber.MIN_NUMBER;

public class AutoLottoGenerator implements LottoGenerator {
    @Override
    public Lotto generateLotto() {
        return new Lotto(generateLottoNumbers());
    }

    private List<LottoNumber> generateLottoNumbers() {
        return generateBaseLottoNumbers().subList(0, LOTTO_SIZE);
    }

    private  List<LottoNumber> generateBaseLottoNumbers() {
        List<LottoNumber> baseLottoNumbers = IntStream.rangeClosed(MIN_NUMBER, MAX_NUMBER)
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toList());
        Collections.shuffle(baseLottoNumbers);

        return baseLottoNumbers;
    }
}
