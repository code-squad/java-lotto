package com.lotto.utils;

import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.google.common.collect.Lists;

public class RandomUtils {

	public static final int LOTTO_NUM_RANGE = 45;

	public static List<Integer> getRandomLottoList(Random rnd) {

		List<Integer> numbers = IntStream.rangeClosed(1, LOTTO_NUM_RANGE).boxed().collect(Collectors.toList());
		Collections.shuffle(numbers);
		return numbers.stream().limit(6).collect(Collectors.toList());
	}
	
	public static List<Integer> getRandomLottoListByStream(Random rnd) {
		return rnd.ints(1, 46).distinct().limit(6).sorted().boxed().collect(Collectors.toList());
	}

	public static int getRandomBonusBall(Random rnd) {
		return rnd.nextInt(LOTTO_NUM_RANGE);
	}

}
