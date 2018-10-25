package lotto.dto;

import java.util.List;

public class LottoManagerDto {
    private List<LottoDto> lottoManagerDto;

    public LottoManagerDto(List<LottoDto> lottoManagerDto) {
        this.lottoManagerDto = lottoManagerDto;
    }

    public List<LottoDto> getLottoManagerDto() {
        return lottoManagerDto;
    }

    public int getLottoManagerSize(){
        return lottoManagerDto.size();
    }

}
