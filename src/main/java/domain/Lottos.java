package domain;

import dto.LottoDto;
import dto.LottosDto;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    private List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public LottosDto toDto() {
        return new LottosDto(makeLottosDto());
    }

    private List<LottoDto> makeLottosDto() {
        List<LottoDto> lottosDtos = new ArrayList<>();
        for (Lotto lotto : lottos) {
            lottosDtos.add(lotto.toDto());
        }
        return lottosDtos;
    }
}
