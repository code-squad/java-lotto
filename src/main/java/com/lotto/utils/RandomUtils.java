package com.lotto.utils;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class RandomUtils {

	public static final int LOTTO_NUM_RANGE = 45;

	public static List<Integer> getRandomLottoList(Random rnd) {
		return rnd.ints(1, 46).distinct().limit(6).sorted().boxed().collect(Collectors.toList());
	}

	public static int getRandomBonusBall(Random rnd) {
		return rnd.nextInt(LOTTO_NUM_RANGE);
	}

}
