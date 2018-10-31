package domain;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import static org.assertj.core.api.Assertions.assertThat;

public class AutoLottoMachineTest {

    @Test
    public void auto_로또() {
        LottoMachineAbstract autoLottos = new AutoLottoMachine(5);
        for (Lotto lotto : autoLottos.getLottos()) {
            System.out.println(lotto);
        }
    }

    @Test
    public void mix_로또() {
        LottoMachineAbstract mixLottos = new MixLottoMachine(3, 3);
        for (Lotto lotto : mixLottos.getLottos()) {
            System.out.println(lotto);
        }
    }
}