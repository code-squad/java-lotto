package lotto.domain;

import lotto.dto.LottoDto;
import lotto.dto.LottoManagerDto;

import java.util.ArrayList;
import java.util.List;

public class LottoManager {
    private List<Lotto> lottos = new ArrayList<>();

    public LottoManager(int money) {
        final int LOTTO_PRICE = 1000;
        int count = money / LOTTO_PRICE;

        if (count < 1) {
            throw new IllegalArgumentException("돈이 부족합니다.");
        }

        for (int i = 0; i < count; i++) {
            addLotto(Lotto.ofAuto());
        }
    }

    public void addLotto(Lotto lotto) {
        lottos.add(lotto);
    }

    public Lotto getLotto(int index) {
        return lottos.get(index);
    }

    public int getSize() {
        return lottos.size();
    }

    public LottoManagerDto toDto(){
        List<LottoDto> lottoDtos = new ArrayList<>();
        for (Lotto lotto : lottos) {
            lottoDtos.add(lotto.toDto());
        }
        return new LottoManagerDto(lottoDtos);
    }
}
