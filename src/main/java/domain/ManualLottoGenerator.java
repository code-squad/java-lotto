package domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ManualLottoGenerator implements LottoGenerator {
    private List<LottoNumber> lottoNumbers;

    public ManualLottoGenerator(String lottoStr) {
        this.lottoNumbers = convertLottoNumbers(lottoStr);
    }

    @Override
    public Lotto generateLotto() {
        return new Lotto(lottoNumbers);
    }

    private static List<LottoNumber> convertLottoNumbers(String inputLottoString) {
        return Arrays.stream(inputLottoString.split(", "))
                .map(Integer::parseInt)
                .map(LottoNumber::new)
                .collect(Collectors.toList());
    }
}
