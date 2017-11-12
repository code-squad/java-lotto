package com.lotto.utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringUtils {
	
	public static List<Integer> makeNumListFromString(String input){
		return Arrays.stream(input.split(" "))
				.mapToInt(s -> (Integer.parseInt(s)))
				.peek(i -> {
					if (i < 1) throw new IllegalArgumentException("입력된 숫자가 너무 작습니다.");
				})
				.boxed().collect(Collectors.toList());
	}

}
