package view;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.assertj.core.api.Assertions.assertThat;

public class InputViewTest {

    @Test
    public void inputPurchaseAmount() {
        assertThat(14000).isEqualTo(InputView.inputPurchaseAmount());
    }

    @Test
    public void inputWinningNums () {
        assertThat("1, 2, 3, 4, 5, 6").isEqualTo(InputView.inputWinningNums());
    }
}