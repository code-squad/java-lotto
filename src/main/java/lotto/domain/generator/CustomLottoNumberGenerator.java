package lotto.domain.generator;

import java.util.List;

public class CustomLottoNumberGenerator implements LottoNumberGenerator {
    private List<Integer> customData;

    public CustomLottoNumberGenerator(List<Integer> customData) {
        this.customData = customData;
    }

    @Override
    public List<Integer> generate() {
        return customData;
    }
}
