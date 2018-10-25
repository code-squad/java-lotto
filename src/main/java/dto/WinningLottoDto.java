package dto;

import vo.Num;

import java.util.*;

public class WinningLottoDto {
    private Set<Num> winningLottoDto;

    public WinningLottoDto(Set<Num> winningLottoDto){
        this.winningLottoDto = winningLottoDto;
    }

    public Set<Num> getWinningLottoDto() {
        return winningLottoDto;
    }
}
