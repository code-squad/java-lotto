package dto;

import vo.No;

import java.util.List;

public class LottoDto {

    List<No> lottoDto;

    private LottoDto(List<No> lotto) {
        this.lottoDto = lotto;
    }

    public static LottoDto init(List<No> lotto) {
        return new LottoDto(lotto);
    }

    public List<No> getLottoDto() {
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
