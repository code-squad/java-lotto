package com.zingoworks.lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoNumberParser {
    public static List<Integer> parse(String inputValue) {
        String[] splitComma = inputValue.split(",");
        List<Integer> lottoNumbers = new ArrayList<>();
        for (String number : splitComma) {
            lottoNumbers.add(Integer.parseInt(number));
        }

        for (Integer lottoNumber : lottoNumbers) {
            if(lottoNumber < 1 || lottoNumber > 45) {
                throw new IllegalArgumentException("유효범위가 아닙니다.");
            }
        }

        return lottoNumbers;
    }
}
