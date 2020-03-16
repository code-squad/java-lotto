package dto;

import domain.Lotto;

import java.util.List;
import java.util.stream.Collectors;

public class LottoPurchaseInfoDto {
    private int numOfLotto;
    private List<LottoDto> lottos;

    public LottoPurchaseInfoDto(int numOfLotto, List<Lotto> lottos) {
        this.numOfLotto = numOfLotto;
        this.lottos = lottos.stream().map(Lotto::toDto).collect(Collectors.toList());
    }

    public int getNumOfLotto() {
        return numOfLotto;
    }

    public List<LottoDto> getLottos() {
        return lottos;
    }
}
