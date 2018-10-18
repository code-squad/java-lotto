package dto;

import java.util.List;

public class LottoDto {
    private final List<List<Integer>> lottos;

    public LottoDto(List<List<Integer>> lottos) {
        this.lottos = lottos;
    }

    public List<List<Integer>> getLottos() {
        return lottos;
    }
}
