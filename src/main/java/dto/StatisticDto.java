package dto;

import vo.Prize;

import java.util.Map;

public class StatisticDto {
    private Map<Prize, Integer> winnerInfo;

    public StatisticDto(Map<Prize, Integer> winnerInfo) {
        this.winnerInfo = winnerInfo;
    }

    public Map<Prize, Integer> getWinnerInfo() {
        return winnerInfo;
    }
}
