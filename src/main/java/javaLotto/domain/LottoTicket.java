package javaLotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoTicket {
    private List<Integer> lottoTicket = new ArrayList<>();

    public LottoTicket(List<Integer> lottoTicket) {
        this.lottoTicket = lottoTicket;
    }

    public List<Integer> getLottoTicket() {
        return lottoTicket;
    }
}
