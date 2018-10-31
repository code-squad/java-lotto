package dto;

import java.util.List;

public class LottoDto {
    private List<Integer> lotto;

    public LottoDto(List<Integer> lotto) {
        this.lotto = lotto;
    }

    public List<Integer> getLotto() {
        return lotto;
    }

    @Override
    public String toString() {
        return "" + lotto;
    }
}
