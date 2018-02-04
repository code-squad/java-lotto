package domain.lotto;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class InputString {
    private String text;

    private InputString(String text) {
        this.text = Optional.ofNullable(text)
                .filter(val->!val.isEmpty())
                .map(val -> val.replaceAll(" ", ""))
                .orElse("");
    }

    public static InputString of(String text) {
        return new InputString(text);
    }

    public List<String> split(String regex) {
        return Arrays.asList(text.split(regex));
    }
}
