package lotto.view;

import lotto.domain.LottoGame;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ResultViewTest {

    @Test
    public void 구매_결과_출력() {
        // given
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        List<List<String>> manualLottos = Arrays.asList(Arrays.asList("1", "2", "3", "4", "5", "6"));

        LottoGame lottoGame = new LottoGame(1_000, manualLottos);

        // when
        ResultView.printLotto(lottoGame);

        // then
        assertThat(outputStream.toString())
                .isEqualTo("수동으로 1장, 자동으로 0개를 구매했습니다.\n[1, 2, 3, 4, 5, 6]\n\n");
    }
}