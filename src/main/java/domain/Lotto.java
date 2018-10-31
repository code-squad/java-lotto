package domain;

import dto.LottoDto;

import java.util.List;

public class Lotto {
    private final int MAX_LOTTO_NUM = 6;
    private List<Integer> lotto;

    public Lotto(List<Integer> lotto) {
        this.lotto = lotto;
    }

    int checkRank(Lotto lotto) {
        int cnt = 0;
        for (int i = 0; i < MAX_LOTTO_NUM; i++) {
            if (lotto.isContains(this.lotto.get(i))) cnt++;
        }
        return cnt;
    }

    private boolean isContains(int number) {
        return this.lotto.contains(number);
    }

    public LottoDto toDto() {
        return new LottoDto(this.lotto);
    }
}
