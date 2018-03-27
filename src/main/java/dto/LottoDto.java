package dto;

import domain.NormalNumber;

public class LottoDto {
    private NormalNumber numbers;
    private int matchPoint;
    private boolean isBonusMatch;

    public LottoDto(NormalNumber numbers, int matchPoint) {
        this.numbers = numbers;
        this.matchPoint = matchPoint;
        this.isBonusMatch = false;
    }

    public int getMatchPoint() {
        return matchPoint;
    }

    public void setBonusMatch(boolean isBonusMatch) {
        this.isBonusMatch = isBonusMatch;
    }

    public NormalNumber getNumbers() {
        return numbers;
    }

    public boolean isMatchPointOfBonus(int matchPoint) {
        return this.matchPoint == matchPoint;
    }

    public boolean isRightMatchPoint(int matchPoint) {
        return this.matchPoint == matchPoint;
    }

    public boolean isRightBonusMatch(boolean isBonusMatch) {
        return this.isBonusMatch == isBonusMatch;
    }

    @Override
    public String toString() {
        return "LottoDto{" +
                "numbers=" + numbers +
                ", matchPoint=" + matchPoint +
                ", isBonusMatch=" + isBonusMatch +
                '}';
    }
}