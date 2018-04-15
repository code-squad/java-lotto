package lotto.view;

import com.google.common.collect.Lists;
import lotto.domain.LottoNumber;
import org.junit.Test;

import java.io.ByteArrayInputStream;

import static org.junit.Assert.*;

public class InputViewTest {

    @Test
    public void 수동으로_구매할_로또_수_입력() {

        // Given
        ByteArrayInputStream in = new ByteArrayInputStream("3".getBytes());
        System.setIn(in);

        // Then
        assertEquals(3, InputView.initManualPurchaseCount());
    }
}