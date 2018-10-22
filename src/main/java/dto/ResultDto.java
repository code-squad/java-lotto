package dto;

import domain.Rank;

import java.util.Map;

public class ResultDto {
    private LottoBundleDto theLottoBundleDto;
    private Map<Rank, Integer> winStats;

    public ResultDto(LottoBundleDto theLottoBundleDto, Map<Rank, Integer> winStats) {
        this.theLottoBundleDto = theLottoBundleDto;
        this.winStats = winStats;
    }

    public int[] getWinStats() {
        return winStats;
    }

    public int getTheLottoBundleDtoSize(){
        return this.theLottoBundleDto.getTheBundleSize();
    }
}
