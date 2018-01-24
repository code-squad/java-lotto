package util;

public class Utils {
    public static int parseInt(String text) {
        return Integer.parseInt(text);
    }

    public static String[] split(String text) {
        return text.split("(, )");
    }
}
