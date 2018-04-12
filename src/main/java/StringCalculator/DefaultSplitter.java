package StringCalculator;

public class DefaultSplitter implements Splitter {

    @Override
    public boolean supports(String inputValue) {
        if (inputValue.contains(",") || inputValue.contains(":")) {
            return true;
        }
        return false;
    }

    @Override
    public String[] split(String inputValue) {
        return inputValue.split(",|:");
    }

}