package util;

public class  Utility {
    public static int fromStringToInteger(String inputString){
        return Integer.parseInt(inputString);
    }

    public static String[] splitComma(String inputString){
        return inputString.split(",");
    }

    public static String blankRemove(String inputString){
        return inputString.replace(" ","");
    }
}
