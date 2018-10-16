package dto;

import java.util.List;

public class LottoDtos {

    private List<LottoDto> lottoDtos;

    private LottoDtos(List<LottoDto> lottoDtos) {
        this.lottoDtos = lottoDtos;
    }

    public static LottoDtos init(List<LottoDto> lottoDtos) {
        return new LottoDtos(lottoDtos);
    }

    public List<LottoDto> getLottoDtos() {
        return this.lottoDtos;
    }


}
