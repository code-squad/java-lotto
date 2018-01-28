package domain.lotto;

import java.util.Arrays;
import java.util.List;

public class InputString {
    private String text;

    private InputString(String text) {
        if (text.isEmpty()) {//parsingLottoNumbers 제거 -> inputString 적용
            return;
        }

        this.text = text.replaceAll(" ", "");
    }

    public static InputString of(String text) {
        return new InputString(text);
    }

    public List<String> split(String regex) {
        return Arrays.asList(text.split(regex));
    }
}
