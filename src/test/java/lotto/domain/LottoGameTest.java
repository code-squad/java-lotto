package lotto.domain;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Moonchan on 2018. 1. 13..
 */
public class LottoGameTest {

    private LottoGame lottoGame;

    @Before
    public void setup() {
        lottoGame = new LottoGame();
    }

    @Test
    public void 로또구입_자동() {
        int ticketCount = lottoGame.buyTicket(10000);
        assertThat(ticketCount).isEqualTo(10);
    }

    @Test
    public void 로또구입_수동만() {
        List<int[]> numbers = Arrays.asList(
                new int[]{1,2,3,4,5,6}, new int[]{1,2,3,4,5,6}
        );
        int ticketCount = lottoGame.buyTicket(2000, numbers);
        assertThat(ticketCount).isEqualTo(2);
    }

    @Test
    public void 로또구입_섞어서() {
        List<int[]> numbers = Arrays.asList(
                new int[]{1,2,3,4,5,6}, new int[]{1,2,3,4,5,6}
        );
        int ticketCount = lottoGame.buyTicket(5000, numbers);
        assertThat(ticketCount).isEqualTo(5);
    }

    @Test
    public void 로또구입_수동_돈이모자름() {
        List<int[]> numbers = Arrays.asList(
                new int[]{1,2,3,4,5,6}, new int[]{1,2,3,4,5,6}
        );
        int ticketCount = lottoGame.buyTicket(1900, numbers);
        assertThat(ticketCount).isEqualTo(0);
    }

    @Test
    public void 로또구입_거스름돈_생기는_케이스() {
        int ticketCount = lottoGame.buyTicket(10500);
        assertThat(ticketCount).isEqualTo(10);
    }

    @Test
    public void 결과확인() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        WinningNumber winningNumber = new WinningNumber(numbers, 7);
        lottoGame.buyTicket(10000);
        LottoResult result = lottoGame.getPrizeResult(winningNumber);
        Map<Prize, Integer> prizeIntegerMap = result.getPrizeResult();

        int count = prizeIntegerMap.values().stream().mapToInt(v -> v).sum();
        assertThat(count).isEqualTo(10);
    }
}
