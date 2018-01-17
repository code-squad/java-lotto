package utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static constant.Constant.*;

/**
 * Created by hoon on 2018. 1. 13..
 */
public class Utils {

    private static List<Integer> numbers;

    static {
        numbers = generateNumbers(NUMBER_BOUNDARY);
    }

    public static List<Integer> generateRandomNumbers(Integer limit) {
        return shuffledNumbers(numbers).subList(START_INDEX, limit);
    }

    public static Double getEarningsRate(Integer totalMoney, Integer winningMoney) {
        return ((winningMoney - totalMoney) / (totalMoney * 1.0)) * 100;
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
}
