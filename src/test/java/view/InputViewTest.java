package view;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class InputViewTest {

    @Test
    public void 로또번호Parser() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        String input = "1, 2, 3, 4, 5, 6";
        assertThat(InputView.inputParser(input), is(numbers));
    }
}
