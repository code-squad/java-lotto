package utils;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.assertj.core.api.Assertions.assertThat;

public class MathHandlerTest {

    @Test
    public void 로또_티켓_개수_구하기() {
        assertThat(14).isEqualTo(MathHandler.getLottoTicketNum(14900));
    }
}