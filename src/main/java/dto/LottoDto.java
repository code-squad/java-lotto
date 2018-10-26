package dto;

import vo.Num;

import java.util.*;

public class LottoDto {
    private List<Num> lottoDto;

    public LottoDto(List<Num> lottoDto) {
        this.lottoDto = lottoDto;
    }

    @Override
    public String toString() {
        return "" + lottoDto;
    }
}
