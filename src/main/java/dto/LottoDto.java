package dto;

import vo.Num;

import java.util.List;

public class LottoDto {
    private List<Num> lottoNumbers;

    public LottoDto(List<Num> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    @Override
    public String toString() {
        return lottoNumbers + "";
    }
}
