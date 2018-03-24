package dto;

import java.util.List;

import static java.util.stream.Collectors.joining;

// DTO : 상태값에 대한 변경 로직이 없어야하며, 상태값의 상태에 대한 조회 로직을 가질 수 있음
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

    @Override
    public String toString() {
        return "[" + "numbers=" + buildUnFoldedNumbers() + ']';
    }

    private String buildUnFoldedNumbers() {
        return numbers.stream().map(String::valueOf).collect(joining(", "));
    }
}
