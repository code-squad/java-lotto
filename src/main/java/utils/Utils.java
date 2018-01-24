package utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static constant.Constant.NUMBER_BOUNDARY;
import static constant.Constant.SHUFFLE_COUNT;
import static constant.Constant.START_INDEX;

/**
 * Created by hoon on 2018. 1. 13..
 */
public class Utils {

    private static List<Integer> numbers;

    static {
        numbers = generateNumbers(NUMBER_BOUNDARY);
    }

    private static List<Integer> shuffledNumbers(List<Integer> numbers) {
        List<Integer> shuffledNumbers = new ArrayList<>();

        shuffledNumbers.addAll(numbers);

        for(int i = 0; i < SHUFFLE_COUNT; i++) {
            Collections.shuffle(shuffledNumbers);
        }

        return shuffledNumbers;
    }

    private static List<Integer> generateNumbers(Integer boundary) {
        List<Integer> numbers = new ArrayList<>();

        for(int i = 1; i <= boundary; i++) {
            numbers.add(i);
        }

        return numbers;
    }

    public static List<Integer> generateRandomNumbers(Integer limit) {
        return shuffledNumbers(numbers).subList(START_INDEX, limit);
    }

    public static Double getEarningsRate(Integer totalMoney, Integer winningMoney) {
        return ((winningMoney - totalMoney) / (totalMoney * 1.0)) * 100;
    }

    public static String[] splitWithDelimiter(String target, String delimiter) {
        if(target == null || target.isEmpty()) {
            throw new IllegalArgumentException();
        }
        return target.split(delimiter);
    }

    public static List<Integer> toIntegerList(String[] target) {
        return Arrays.stream(target)
                .flatMapToInt(s -> IntStream.of(Integer.parseInt(s)))
                .boxed()
                .collect(Collectors.toList());
    }
}
