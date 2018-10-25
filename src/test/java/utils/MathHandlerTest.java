package utils;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.assertj.core.api.Assertions.assertThat;

public class MathHandlerTest {

    @Test
    public void 로또_티켓_개수_구하기() {
        assertThat(14).isEqualTo(MathHandler.getLottoTicketNum(14900));
    }

    @Test
    public void 수익률_구하기() {
        assertThat(MathHandler.getProfit(10000, 1000)).isEqualTo(1000);
    }

    @Test
    public void 소수점_나타내기() {
        int a = 10;
        int b = 20;
        System.out.println((int)(a / (double)b * 100));
    }
}