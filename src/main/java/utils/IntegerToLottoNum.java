package utils;

import domain.LottoNum;

import java.util.ArrayList;
import java.util.List;

public class IntegerToLottoNum {

    public static List<LottoNum> convertLottoNums(List<Integer> Integers) {
        List<LottoNum> LottoNums = new ArrayList<>();
        for (Integer integer : Integers) {
            LottoNums.add(new LottoNum(integer));
        }
        return LottoNums;
    }
}
