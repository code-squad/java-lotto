package domain;

import dto.LottoResult;

import static common.Constant.LOTTO_PRICE;

public class Lotto {

    private final LottoNumbers lottoNumbers;

    public Lotto(LottoNumbers lottoNumbers) {
        if (lottoNumbers == null) {
            throw new IllegalArgumentException();
        }
        this.lottoNumbers = lottoNumbers;
    }

    public static int getCountOfBuy(int money) {
        if (money < 0) {
            throw new IllegalArgumentException("인자는 0보다 커야 합니다");
        }
        return money / LOTTO_PRICE;
    }

    public LottoResult getLottoResult(WinningNumbers winningNumber) {
        return lottoNumbers.getWinResult(winningNumber);
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }
}
