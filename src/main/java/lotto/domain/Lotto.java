package lotto.domain;

import com.google.common.collect.Lists;

import java.util.List;

public class Lotto {

    private static final int LOTTO_PRICE = 1000;

    public static List<LottoNumber> purchase(int purchasePrice) {
        return create(purchasePrice / LOTTO_PRICE);
    }

    static List<LottoNumber> create(int purchaseCount) {
        List<LottoNumber> lottoNumbers = Lists.newArrayList();

        for (int i = 0; i < purchaseCount; i++)
            lottoNumbers.add(createLottoNumber());
        return lottoNumbers;
    }

    static LottoNumber createLottoNumber() {
        return new LottoNumber();
    }
}
