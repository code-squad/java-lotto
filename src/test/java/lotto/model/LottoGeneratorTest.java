package lotto.model;

import static org.junit.Assert.*;

import org.junit.Test;

import lotto.model.LottoGenerator;
import lotto.model.Lottos;
import lotto.model.UserLotto;

public class LottoGeneratorTest {

    @Test
    public void generateByMoney() {
        Lottos lottos = LottoGenerator.generateByMoney(5000);
        System.out.println(lottos);
        assertEquals(5, lottos.count());
    }
    
    @Test
    public void generateAuto() throws Exception {
        UserLotto lotto = LottoGenerator.generateAuto();
        System.out.println(lotto);
    }

}
