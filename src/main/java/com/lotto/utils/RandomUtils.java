package com.lotto.utils;

import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import com.google.common.collect.Lists;

public class RandomUtils {
	
	public static final int LOTTO_NUM_RANGE = 45;

	public static List<Integer> getRandomLottoList(Random rnd) {
		List<Integer> numbers = Lists.newArrayList();
		for (int i = 1; i < LOTTO_NUM_RANGE + 1; i++) {
			numbers.add(i);
		}
		Collections.shuffle(numbers);
		return numbers.stream().limit(6).collect(Collectors.toList());
	}
	
	public static int getRandomBonusBall(Random rnd) {
		return rnd.nextInt(LOTTO_NUM_RANGE);
	}

}
