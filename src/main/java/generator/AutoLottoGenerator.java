package generator;

import domain.Lotto;
import vo.LottoNumber;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static domain.Lotto.LOTTO_SIZE;
import static vo.LottoNumber.MAX_NUMBER;
import static vo.LottoNumber.MIN_NUMBER;

public class AutoLottoGenerator implements LottoGenerator {
    private List<Lotto> lottoNumbers = new ArrayList<>();

    public AutoLottoGenerator(int autoLottoSize) {
        for (int i = 0; i < autoLottoSize; i++) {
            lottoNumbers.add(new Lotto(generateLottoNumbers()));
        }
    }

    private List<LottoNumber> generateLottoNumbers() {
        return generateBaseLottoNumbers().subList(0, LOTTO_SIZE);
    }

    private List<LottoNumber> generateBaseLottoNumbers() {
        List<Integer> baseNumbers = IntStream.rangeClosed(MIN_NUMBER, MAX_NUMBER)
                .boxed()
                .collect(Collectors.toList());
        List<LottoNumber> baseLottoNumbers = LottoGenerator.convertToLottoNumber(baseNumbers);
        Collections.shuffle(baseLottoNumbers);

        return baseLottoNumbers;
    }

    @Override
    public List<Lotto> generateLotto() {
        return lottoNumbers;
    }
}
