package dto;

import java.util.List;

public class LottoDto {
    private List<Integer> numbers;
    private int matchPoint;

    public LottoDto(List<Integer> numbers, int matchPoint) {
        this.numbers = numbers;
        this.matchPoint = matchPoint;
    }

    public int getMatchPoint() {
        return matchPoint;
    }

    public boolean isRightMatchPoint(int matchPoint) {
        return this.matchPoint == matchPoint;
    }
}
