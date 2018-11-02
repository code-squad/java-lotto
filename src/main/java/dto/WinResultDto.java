package dto;

import vo.Rank;

import java.util.HashMap;
import java.util.Map;

public class WinResultDto {

    private Map<Rank, Integer> winResultDto;

    private WinResultDto(Map<Rank, Integer> winResultDto) {
        this.winResultDto = winResultDto;
    }

    public static WinResultDto initArtifitial(Map<Rank, Integer> winResultDto) {
        return new WinResultDto(winResultDto);
    }

    public static WinResultDto initAuto() {
        Map<Rank, Integer> winResultDto = new HashMap<>();

        return new WinResultDto(initValues(winResultDto));
    }

    private static Map<Rank, Integer> initValues(Map<Rank, Integer> winResultDto) {
        for (Rank rank : Rank.values()) {
            winResultDto.put(rank, 0);
        }
        return winResultDto;
    }

    public void setRankAmt(Rank rank) {
        int amt = this.winResultDto.remove(rank);

        this.winResultDto.put(rank, ++amt);
    }

    public Map<Rank, Integer> getWinResultDto() {
        return this.winResultDto;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        for (Rank rank : winResultDto.keySet()) {
            sb.append(" (" + rank + " : " + this.winResultDto.get(rank) + ") ");
        }
        sb.append("}");

        return sb.toString();
    }

}
