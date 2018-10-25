package lotto.dto;

import java.util.List;

public class LottoDto {
    private List<Integer> lottoDto;

    public LottoDto(List<Integer> lottoDto) {
        this.lottoDto = lottoDto;
    }

    @Override
    public String toString() {
        return "" + lottoDto;
    }
}
