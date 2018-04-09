package lotto.view;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;

public class InputViewTest {

    @Test
    public void 구매액을_입력하면_구매한_로또_갯수를_보여준다() {
        // given
        final String inputAmount = "14000";

        ByteArrayInputStream inputStream
                = new ByteArrayInputStream(inputAmount.getBytes());
        System.setIn(inputStream);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // when
        int actual = InputView.getAmount();

        // then
        assertThat(actual)
                .isEqualTo(Integer.parseInt(inputAmount));

        assertThat(outputStream.toString())
                .isEqualTo("구입금액을 입력해 주세요.\n");
    }
}