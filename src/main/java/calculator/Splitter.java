package calculator;

public interface Splitter {

    boolean supports(String param);
    String[] split(String param);
}
