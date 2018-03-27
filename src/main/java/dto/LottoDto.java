package dto;

public class LottoDto {
    private int matchPoint;
    // TODO : enum을?
    public LottoDto(int matchPoint) {
        this.matchPoint = matchPoint;
    }

    public int getMatchPoint() {
        return matchPoint;
    }
}
