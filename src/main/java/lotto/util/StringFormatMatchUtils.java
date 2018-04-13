package lotto.util;

import java.util.regex.Pattern;

public class StringFormatMatchUtils {
	public static boolean matchNumberFormat(String string) {
		return Pattern.compile("(^[0-9]*$)").matcher(string).find();
	}
	
	public static boolean matchNumbersFormat(String string) {
		return Pattern.compile("^(([0-9]+)(,|,\\s))*([0-9]+)$").matcher(string).find();
	}
}
