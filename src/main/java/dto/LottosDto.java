package dto;

import java.util.List;

public class LottosDto {
    private List<LottoDto> lottos;

    public LottosDto(List<LottoDto> lottos) {
        this.lottos = lottos;
    }

    public int getSize(){
        return lottos.size();
    }

    public List<LottoDto> getLottos() {
        return lottos;
    }
}
