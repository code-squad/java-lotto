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

    public boolean isBonusMatchPoint(int matchPoint) {
        return this.matchPoint == matchPoint;
    }

    public void setBonusMatch(boolean isBonusMatch) {
        this.isBonusMatch = isBonusMatch;
    }

    public boolean isRightMatchPoint(int matchPoint) {
        return this.matchPoint == matchPoint;
    }

    public boolean isContainBonusNumber(int bonusNumber) {
        return numbers.isContainNumber(bonusNumber);
    }
}
