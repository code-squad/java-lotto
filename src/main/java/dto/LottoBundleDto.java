package dto;

import java.util.List;

public class LottoBundleDto {
    private List<LottoDto> lottos;

    public LottoBundleDto(List<LottoDto> lottos) {
        this.lottos = lottos;
    }

    public List<LottoDto> getLottos() {
        return lottos;
    }

}
