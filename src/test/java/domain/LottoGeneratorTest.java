package domain;

import dto.WinResultDto;
import org.junit.Before;
import org.junit.Test;

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
        WinResultDto result = lottoGenerator.checkWins(lotto1.toLottoDto());

        System.out.println(result);
    }


}