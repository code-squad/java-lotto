package domain;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class LottoMachineTest {
    LottoMachine lottoMachine = new LottoMachine();

    @Test
    public void getManualTickets() {
        // 2개의 수동 입력이 들어올 때, 2개의 LottoTicket을 만들어 내는가?
        List<String> numbers = new ArrayList<>(Arrays.asList("1,2,3,4,5,6", "7,8,9,10,11,12"));
        List<LottoTicket> lottoTickets = lottoMachine.createManualTickets(numbers);
        assertEquals(2, lottoTickets.size());
    }

    @Test
    public void createAutoTickets() {
        List<LottoTicket> lottoTickets = lottoMachine.createAutoTickets(6);
        assertEquals(6, lottoTickets.size());
    }

    @Test
    public void getTotalCount() {
        assertEquals(10, LottoMachine.getTotalCount(10000));
    }

    @Test(expected = IllegalArgumentException.class)
    public void checkUnderPayment() {
        LottoMachine.getTotalCount(100);
    }

    @Test
    public void getAutoCount() {
        assertEquals(6, LottoMachine.getAutoCount(10, 4));
    }

    @Test(expected = IllegalArgumentException.class)
    public void checkOverManualCount() {
        LottoMachine.getAutoCount(10, 11);
    }
}