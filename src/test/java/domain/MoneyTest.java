package domain;

import dto.LottoDto;
import dto.WinResultDto;
import org.junit.Before;
import org.junit.Test;
import vo.No;
import vo.Rank;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class MoneyTest {

    WinResultDto winResultDto;

    @Before
    public void setUp() throws Exception {
        List<No> lottoNums = new ArrayList<>();
        List<LottoDto> lottoDtos = new ArrayList<>();
        for (int i = 1; i <= 6; i++) {
            lottoNums.add(new No(i));
        }

        lottoDtos.add(LottoDto.init(lottoNums));
        lottoDtos.add(LottoDto.init(lottoNums));
        lottoDtos.add(LottoDto.init(lottoNums));

        WinningLotto winningLotto = new WinningLotto(Lotto.initArtifitial(lottoNums), new No(7));
        LottoGenerator lottoGenerator = LottoGenerator.initArtifitial(lottoDtos);

        winResultDto = winningLotto.checkWins(lottoGenerator.toLottoDtos());
    }

    @Test
    public void getLottoAmt() {
        int n = 14000;
        Money money = new Money(n);

        assertEquals(14, money.getLottoAmt());
    }

    @Test
    public void getYield() {
        Money money = new Money(3000);
        System.out.println(winResultDto);

        long result = (((long) Rank.FIRST.getReward() * 3) / 3000) * 100;

        assertEquals(result, money.getYield(winResultDto));
    }
}