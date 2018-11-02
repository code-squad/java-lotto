package util;

import dto.LottoDto;
import dto.LottosDto;
import vo.No;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Parser {

    public static LottosDto strValueToLottoDto(String inputValues) {
        return LottosDto.init(Arrays.asList(inputValues.split("\r?\n"))
                .stream()
                .map(v -> strToInt(v))
                .collect(Collectors.toList()));
    }

    public static LottoDto strToInt(String value) {
        return LottoDto.init((List<No>) Arrays.asList(value.split(","))
                .stream()
                .map(Integer::parseInt)
                .map(No::new)
                .collect(Collectors.toList()));
    }

    public static No strToNo(String value) {
        return new No(Integer.parseInt(value));
    }

    public static LottoDto parseDbRow(String value) {
        return LottoDto.init((List<No>) Arrays.asList(value.substring(1,value.length()-1).split(", "))
                .stream()
                .map(Integer::parseInt)
                .map(No::new)
                .collect(Collectors.toList()));
    }

}
