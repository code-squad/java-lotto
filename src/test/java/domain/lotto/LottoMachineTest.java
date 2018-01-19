package domain.lotto;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


public class LottoMachineTest {

    private LottoMachine lottoMachine;

    @Before
    public void init() {
        lottoMachine = new LottoMachine();
    }

    @Test
    public void InputMoney() {
        lottoMachine.insertMoney("14000");
        assertThat(lottoMachine.getMoney(), is(14000));
    }
}
