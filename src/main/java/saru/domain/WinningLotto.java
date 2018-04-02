package saru.domain;

import java.util.List;

public class WinningLotto {
    private List<LottoNum> numbers;

    private WinningLotto(List<LottoNum> numbers) {
        this.numbers = numbers;
    }

    public static WinningLotto of(List<LottoNum> hitLottoLine) {
        return new WinningLotto(hitLottoLine);
    }

    List<LottoNum> getNumbers() {
        return numbers;
    }

    boolean checkContain(LottoNum lottoNum) {
        return numbers.contains(lottoNum);
    }
}