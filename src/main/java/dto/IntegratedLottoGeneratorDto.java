package dto;

import domain.Lotto;

import java.util.List;
import java.util.stream.Collectors;

public class IntegratedLottoGeneratorDto {
    private List<LottoDto> lottos;

    public IntegratedLottoGeneratorDto(List<Lotto> lottos) {
        this.lottos = lottos.stream().map(Lotto::toDto).collect(Collectors.toList());
    }

    public List<LottoDto> getLottos() {
        return lottos;
    }
}
