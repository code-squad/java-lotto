package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class GameResultTest {

    private GameResult gameResult;
    private List<LottoTicket> tickets;
    private WinningTicket winningTicket;

    @Before
    public void setUp() {
        LottoTicket losingTicket = new LottoTicket(Arrays.asList(7, 8, 9, 10, 11, 12));
        winningTicket = new WinningTicket(Arrays.asList(1, 2, 3, 4, 5, 6), 45);
        
        tickets = Arrays.asList(winningTicket, losingTicket);
        
        gameResult = new GameResult(tickets, winningTicket);
    }

    @Test
    public void 당첨된_상금과_맞춘_숫자를_알_수_있다() {
        //given when
        List<PrizeDivision> result = gameResult.getResult();

        //then
        Assertions.assertThat(result.get(0).getMatchedNumber()).isEqualTo(PrizeDivision.FIRST.getMatchedNumber());
        Assertions.assertThat(result.get(0).getPrize()).isEqualTo(PrizeDivision.FIRST.getPrize());
    }

    @Test
    public void 각_등수별_당첨된_티켓수를_반환한다() {
        //given when
        Map<PrizeDivision, Integer> prizeDivisions = gameResult.analyzeResult();

        //then
        Assertions.assertThat(prizeDivisions.get(PrizeDivision.FIRST)).isEqualTo(1);
        Assertions.assertThat(prizeDivisions.get(PrizeDivision.SECOND)).isEqualTo(0);
        Assertions.assertThat(prizeDivisions.get(PrizeDivision.THIRD)).isEqualTo(0);
        Assertions.assertThat(prizeDivisions.get(PrizeDivision.FOURTH)).isEqualTo(0);
        Assertions.assertThat(prizeDivisions.get(PrizeDivision.FIFTH)).isEqualTo(0);
        Assertions.assertThat(prizeDivisions.get(PrizeDivision.DEFAULT)).isEqualTo(1);
    }
}