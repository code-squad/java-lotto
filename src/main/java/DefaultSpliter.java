import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DefaultSpliter implements Spliter {

    private static final String DEFAULT_DELIMITER = ",|:";
    private String input;

    DefaultSpliter(String input) {
        this.input = input;
    }

    @Override
    public Positive split() {
        return new Positive(getSplited());
    }

    private List<Integer> getSplited() {
        return Arrays.stream(input.split(DEFAULT_DELIMITER)).map(Integer::new).collect(Collectors.toCollection(ArrayList::new));
    }
}
