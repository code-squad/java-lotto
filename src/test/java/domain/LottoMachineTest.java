package domain;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class LottoMachineTest {
    @Test
    public void getManualTickets() {
        LottoMachine lottoMachine = new LottoMachine();
        // 2개의 수동 입력이 들어올 때, 2개의 LottoTicket을 만들어 내는가?
        List<String> numbers = new ArrayList<>(Arrays.asList("1,2,3,4,5,6", "7,8,9,10,11,12"));
        List<LottoTicket> lottoTickets = lottoMachine.getManualTickets(numbers);
        assertEquals(2, lottoTickets.size());
    }
}
