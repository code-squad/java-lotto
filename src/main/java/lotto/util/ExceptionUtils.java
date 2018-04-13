package lotto.util;

public class ExceptionUtils {
	public static void throwIllegalArgumentException(Class throwClass, String message) {
		throw new IllegalArgumentException("\n" + throwClass.getName() + " - " + message);
	}
}
