package com.codesquad.lotto.domain;

import com.codesquad.lotto.vo.LottoNumber;

import java.util.List;
import java.util.Objects;

public class WinningLotto extends Lotto {
    private final LottoNumber bonusNumber;

    private WinningLotto(final List<LottoNumber> numbers, final LottoNumber bonusNumber) {
        super(numbers);
        this.bonusNumber = bonusNumber;
    }

    public static WinningLotto fromList(List<LottoNumber> numbers, LottoNumber bonusNumber) {
        return new WinningLotto(numbers, bonusNumber);
    }

    public static WinningLotto fromComma(final String numbers, final String bonusNumber) {
        final List<LottoNumber> lottoNumbers = parseLottoNumbers(numbers);
        final LottoNumber number = LottoNumber.from(bonusNumber);
        return new WinningLotto(lottoNumbers, number);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        final WinningLotto that = (WinningLotto) o;
        return Objects.equals(bonusNumber, that.bonusNumber);
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), bonusNumber);
    }

    public boolean matchedBonus(final Lotto lotto) {
        return lotto.contains(bonusNumber);
    }
}
