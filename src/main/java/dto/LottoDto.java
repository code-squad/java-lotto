package dto;

import vo.Num;

import java.util.*;

public class LottoDto {
    private Set<Num> lottoDto;

    public LottoDto(Set<Num> lottoDto) {
        this.lottoDto = lottoDto;
    }

//    public Set<Num> getLottoDto() {
//        return lottoDto;
//    }

    @Override
    public String toString() {
        return "" + lottoDto;
    }
}
