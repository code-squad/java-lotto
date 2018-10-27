package lotto.dto;

import lotto.domain.Lotto;

import java.util.List;

public class LottoDto {
    private List<Lotto> lottos;
    private int numberOfLottoToBuyManually;

    public LottoDto(List<Lotto> lottos, int numberOfLottoToBuyManually) {
           this.lottos = lottos;
           this.numberOfLottoToBuyManually = numberOfLottoToBuyManually;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public int getNumberOfLottoToBuyManually() {
        return numberOfLottoToBuyManually;
    }
}
