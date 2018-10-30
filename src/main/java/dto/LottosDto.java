package dto;

import domain.Lotto;

import java.util.List;

public class LottosDto {
    private List<LottoDto> lottos;

    public LottosDto(List<LottoDto> lottos){
        this.lottos = lottos;
    }

}
