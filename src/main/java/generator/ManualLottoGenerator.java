package generator;

import domain.Lotto;

import java.util.List;
import java.util.stream.Collectors;

import static util.StringUtil.convertToInt;
import static util.StringUtil.split;

public class ManualLottoGenerator implements LottoGenerator {
    private List<Lotto> lottoNumbers;

    public ManualLottoGenerator(List<String> manualLottos) {
        this.lottoNumbers = manualLottos.stream()
                .map(m -> convertToLottoNumber(convertToInt(split(m))))
                .map(Lotto::new)
                .collect(Collectors.toList());
    }

    @Override
    public List<Lotto> generateLotto() {
        return lottoNumbers;
    }
}
