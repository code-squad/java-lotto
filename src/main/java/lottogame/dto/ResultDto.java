package lottogame.dto;

import lottogame.domain.PrizeRank;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ResultDto {
    String result;

    public ResultDto(String result) {
        this.result = result;
    }

    public static List<ResultDto> listOf(Result result) {
        return Arrays.stream(PrizeRank.values())
                    .filter(x -> x != PrizeRank.BOOM)
                    .map(x -> x.getMessage() + "-" + result.get(x) + "개")
                    .map(ResultDto::new)
                    .collect(Collectors.toList());
    }

    public String getResult() {
        return result;
    }
}
