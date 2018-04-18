package lottoGame.model;

import lottoGame.model.LottoMachine;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoMachineTest {

    @Test
    public void test_LottoMachine_createLottoGame(){
        assertThat(LottoMachine.createLottoGame(14).size()).isEqualTo(14);
    }

}
