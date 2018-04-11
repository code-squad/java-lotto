package lotto.view;

import java.util.List;

public class LottoViewDto {

    private List<Integer> lottos;

    public LottoViewDto(List<Integer> lottos) {
        this.lottos = lottos;
    }

    public List<Integer> getLottos() {
        return this.lottos;
    }
}
