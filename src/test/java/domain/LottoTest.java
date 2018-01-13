package domain;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoTest {
    @Test
    public void createLottoTicketTest() {
        Lotto lotto = new Lotto();
        
        System.out.println(lotto);
    }
}
