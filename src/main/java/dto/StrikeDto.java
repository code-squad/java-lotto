package dto;

import java.util.Objects;

public class StrikeDto {
    private int strikePoint;
    private boolean strikeBonus;

    public StrikeDto(int strikePoint, boolean strikeBonus) {
        this.strikePoint = strikePoint;
        this.strikeBonus = strikeBonus;
    }

    public int getStrikePoint() {
        return strikePoint;
    }

    public boolean getStrikeBonus() {
        return strikeBonus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StrikeDto strikeDto = (StrikeDto) o;
        return strikePoint == strikeDto.strikePoint &&
                strikeBonus == strikeDto.strikeBonus;
    }

    @Override
    public int hashCode() {
        return Objects.hash(strikePoint, strikeBonus);
    }
}
