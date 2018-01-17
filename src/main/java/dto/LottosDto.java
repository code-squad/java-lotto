package dto;

import domain.Lotto;

import java.util.ArrayList;
import java.util.List;

public class LottosDto {
    List<Lotto> lottos = new ArrayList<>();

    public LottosDto(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
