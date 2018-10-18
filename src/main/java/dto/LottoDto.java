package dto;

import java.util.List;

public class LottoDto {

    List<NoDto> lottoDto;

    private LottoDto(List<NoDto> lotto) {
        this.lottoDto = lotto;
    }

    public static LottoDto init(List<NoDto> lotto) {
        return new LottoDto(lotto);
    }

    public List<NoDto> getLottoDto() {
        return this.lottoDto;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");

        for (int i = 0; i < lottoDto.size(); i++) {
            sb.append(lottoDto.get(i));
            if (i < lottoDto.size() - 1) sb.append(", ");
        }
        sb.append("]");

        return sb.toString();
    }

}
