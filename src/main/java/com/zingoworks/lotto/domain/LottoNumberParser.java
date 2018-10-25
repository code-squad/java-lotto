package com.zingoworks.lotto.domain;

import java.util.ArrayList;
import java.util.List;

import static com.zingoworks.lotto.domain.Lotto.MAX_RANGE;
import static com.zingoworks.lotto.domain.Lotto.MIN_RANGE;

public class LottoNumberParser {
    private static final String COMMA = ",";

    public static List<Integer> parse(String inputValue) {
        String[] splitComma = inputValue.split(COMMA);
        List<Integer> lottoNumbers = new ArrayList<>();
        for (String number : splitComma) {
            lottoNumbers.add(Integer.parseInt(number));
        }

        for (Integer lottoNumber : lottoNumbers) {
            if(lottoNumber < MIN_RANGE || lottoNumber > MAX_RANGE) {
                throw new IllegalArgumentException("유효범위가 아닙니다.(1~45)");
            }
        }

        return lottoNumbers;
    }
}
