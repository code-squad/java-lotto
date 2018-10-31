package com.zingoworks.lotto.model.lotto;

import com.zingoworks.lotto.model.Prize;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static com.zingoworks.lotto.model.lotto.LottoNumber.MAXIMUM_RANGE;
import static com.zingoworks.lotto.model.lotto.LottoNumber.MINIMUM_RANGE;
import static java.util.stream.Collectors.toList;

public class Lotto {
    private static final String COMMA = ",";
    private static final int REGULAR_CHOICE = 6;
    private static List<LottoNumber> basicNumbers;
    private List<LottoNumber> lotto;

    static {
        basicNumbers = IntStream.rangeClosed(MINIMUM_RANGE, MAXIMUM_RANGE)
            .boxed()
            .map(LottoNumber::of)
            .collect(toList());
    }

    private Lotto(List<LottoNumber> lotto) {
        this.lotto = lotto;
    }

    private Lotto(String lotto) {
        this.lotto = Arrays.stream(lotto.split(COMMA))
                .map(LottoNumber::of)
                .collect(Collectors.toList());
    }

    public static Lotto random() {
        Collections.shuffle(basicNumbers);
        return new Lotto(basicNumbers.stream().limit(REGULAR_CHOICE).collect(toList()));
    }

    public static Lotto of(String value) {
        return new Lotto(value);
    }

//    위닝로또의 메서드와 중복? 혹은 위임?
    public Prize getPrize(WinningLotto winningLotto) {
        return winningLotto.getPrize(this);
    }

//    간결하게 개선 가능?
    int match(Lotto otherLotto) {
        int count = 0;
        for (LottoNumber lottoNumber : lotto) {
            if(otherLotto.isContain(lottoNumber)) {
                count++;
            }
        }
        return count;
    }

    boolean isContain(LottoNumber number) {
        return lotto.contains(number);
    }

    @Override
    public String toString() {
        return "[" + sortedLottoNumbers(this.lotto) + "]";
    }

//    colin의 코드에서 차용했습니다.
    private String sortedLottoNumbers(List<LottoNumber> lotto) {
        return lotto.stream()
                .sorted(LottoNumber::compareTo)
                .map(LottoNumber::toString)
                .collect(Collectors.joining(", "));
    }
}