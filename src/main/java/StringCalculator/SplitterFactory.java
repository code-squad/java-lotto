package StringCalculator;

public class SplitterFactory {
    public static Splitter getSplitter(String inputValue) {
        if (new CustomSplitter().supports(inputValue)) {
            return new CustomSplitter();
        }
        return new DefaultSplitter();
    }
}