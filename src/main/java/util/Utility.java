package util;

public class Utility {
    public static int fromStringToInteger(String inputString) {
        return Integer.parseInt(inputString);
    }

    public static String[] splitComma(String inputString) {
        return inputString.split(",");
    }

    public static String blankRemove(String inputString) {
        return inputString.replace(" ", "");
    }

    public static int divideThousand(int purchase) {
        return purchase / 1000;
    }

    public static int multiplyThousand(int lottoCount) {
        return lottoCount * 1000;
    }

    public static int multiplyHundred(double rate) {
        return (int)rate * 100;
    }
}
