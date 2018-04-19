package StringCalculator;

public interface Splitter {

    public boolean supports(String inputValue);

    public String[] split(String inputValue);

}