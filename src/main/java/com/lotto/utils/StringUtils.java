package com.lotto.utils;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StringUtils {
	
	public static List<Integer> makeNumListFromString(String input){
		return Arrays.stream(input.split(" "))
				.mapToInt(s -> (Integer.parseInt(s)))
				.peek(i -> {
					if (i < 1) throw new IllegalArgumentException("입력된 숫자가 너무 작습니다.");
				})
				.boxed().collect(Collectors.toList());
	}
	
	<T> Function<T, Stream<RuntimeException>> exceptions(Consumer<T> cons){
		return t -> {
			try {
				cons.accept(t);
				return Stream.empty();
			} catch (RuntimeException re) {
				return Stream.of(re);
			}
		};
	}
}
