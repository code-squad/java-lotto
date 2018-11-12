package domain;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class AutoLottoMachineTest {

    @Test
    public void 자동_로또_생성기() {
        AutoLottoMachine autoLottoMachine = new AutoLottoMachine();
        List<Lotto> lottos = autoLottoMachine.generate(new Money(7000));
        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
    }
}