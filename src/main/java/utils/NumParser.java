package utils;

import domain.LottoNum;

import java.util.ArrayList;
import java.util.List;

public class NumParser {
    public static final String COMMA = ",";

    private NumParser() {
    }

    public static List<LottoNum> parse(String inputLottoNum) {
        List<LottoNum> lottoNums = new ArrayList<>();
        for (String num : inputLottoNum.split(COMMA)) {
            lottoNums.add(LottoNum.ofLottoNum(Integer.parseInt(num.trim())));
        }
        return lottoNums;
    }
}
