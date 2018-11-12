package domain;

import dto.LottoDto;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;
import static org.assertj.core.api.Assertions.assertThat;

public class ManualLottoMachineTest {

    @Test
    public void 문자열_분리하기() {
        String[] test = "1,2,3,4,5,6\r3,4,5,6,7,8".split("\n?\r");
        for (String s : test) {
            System.out.println(s);
        }
    }

    @Test
    public void 로또_테스트() {
        ManualLottoMachine manualLottoMachine = new ManualLottoMachine("1,2,3,4,5,6\r3,4,5,6,7,8");
        List<Lotto> lottos = manualLottoMachine.generate(new Money(10_000));
        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
    }

    @Test
    public void LottoGame_테스트() {
        Money money = new Money(Integer.parseInt("10000"));
        LottoMachine lottoMachine = new ManualLottoMachine("1,2,3,4,5,6\r3,4,5,6,7,8");
        LottoDto lottoDto = new LottoGame().generateLottos(money, lottoMachine);
        for (Lotto lotto : lottoDto.getLottos()) {
            System.out.println(lotto);
        }
    }
}