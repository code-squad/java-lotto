package lotto.view;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

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
        assertThat(outputStream.toString())
                .isEqualTo("구입금액을 입력해 주세요.\n");

        assertThat(actual)
                .isEqualTo(Integer.parseInt(inputAmount));
    }

    @Test
    public void 수동으로_구매할_로또_수를_입력해_주세요() {
        // given
        final String inputNumber = "3";

        ByteArrayInputStream inputStream
                = new ByteArrayInputStream(inputNumber.getBytes());
        System.setIn(inputStream);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // when
        int actual = InputView.getManualLottoCount();

        // then
        assertThat(outputStream.toString())
                .isEqualTo("수동으로 구매할 로또 수를 입력해 주세요.\n");

        assertThat(actual)
                .isEqualTo(Integer.parseInt(inputNumber));
    }

    @Test
    public void 수동으로_구매할_번호를_입력해_주세요() {
        // given
        final String inputNumbers = "8,21,23,41,42,43";

        ByteArrayInputStream inputStream
                = new ByteArrayInputStream(inputNumbers.getBytes());
        System.setIn(inputStream);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // when
        List<List<String>> actual = InputView.getManualLotto(1);

        // then
        assertThat(outputStream.toString())
                .isEqualTo("수동으로 구매할 번호를 입력해 주세요.\n");

        assertThat(actual.toString())
                .isEqualTo("[[8, 21, 23, 41, 42, 43]]");
    }
}