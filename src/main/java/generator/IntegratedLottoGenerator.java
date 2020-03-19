package generator;

import domain.Lotto;
import dto.IntegratedLottoGeneratorDto;

import java.util.ArrayList;
import java.util.List;

public class IntegratedLottoGenerator implements LottoGenerator {
    private List<Lotto> lottos = new ArrayList<>();

    public IntegratedLottoGenerator(List<Lotto> autoLottos, List<Lotto> manualLottos) {
        integrateLottos(autoLottos, manualLottos);
    }

    private void integrateLottos(List<Lotto> autoLottos, List<Lotto> manualLottos) {
        lottos.addAll(autoLottos);
        lottos.addAll(manualLottos);
    }

    @Override
    public List<Lotto> generateLotto() {
        return lottos;
    }

    public IntegratedLottoGeneratorDto toDto() {
        return new IntegratedLottoGeneratorDto(lottos);
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
