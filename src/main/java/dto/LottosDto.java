package dto;

import java.util.List;

public class LottosDto {

    private List<LottoDto> lottoDtos;

    private LottosDto(List<LottoDto> lottoDtos) {
        this.lottoDtos = lottoDtos;
    }

    public static LottosDto init(List<LottoDto> lottoDtos) {
        return new LottosDto(lottoDtos);
    }

    public List<LottoDto> getLottoDtos() {
        return this.lottoDtos;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");

        for (int i = 0; i < lottoDtos.size(); i++) {
            sb.append(lottoDtos.get(i));
            if (i < lottoDtos.size() - 1) sb.append(", ");
        }
        sb.append("]");

        return sb.toString();
    }

}
