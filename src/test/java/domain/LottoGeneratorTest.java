package domain;

import dto.WinResultDto;
import org.junit.Before;
import org.junit.Test;
import vo.No;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class LottoGeneratorTest {

    LottoGenerator lottoGenerator;
    Lotto lotto1;
    Lotto lotto2;

    @Before
    public void setUp() {
        List<Lotto> lottos = new ArrayList<>();
        lotto1 = Lotto.init();
        lotto2 = Lotto.init();

        lottos.add(lotto1);
        lottos.add(lotto2);

        lottoGenerator = LottoGenerator.initArtifitial(lottos);
    }

    @Test
    public void checkWins() {
        No bonusNum = new No(3);
        WinResultDto result = lottoGenerator.checkWins(lotto1.toLottoDto(), bonusNum);

        System.out.println(result);
    }


}