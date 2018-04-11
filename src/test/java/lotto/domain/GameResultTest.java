package lotto.domain;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class GameResultTest {

    @Test
    public void 당첨번호_생성() {
        List<String> numbers = Arrays.asList("1", "2", "3", "4", "5", "6");
        GameResult actual = new GameResult(numbers);
        Lotto expected = new Lotto(numbers);

        assertThat(actual.getWinning())
                .isEqualTo(expected);
    }

    @Test
    public void 당첨번호_3개_매칭() {
        List<String> winningNumbers = Arrays.asList("1", "2", "3", "4", "5", "6");
        List<String> matchNumbers = Arrays.asList("1", "2", "3", "7", "8", "9");

        GameResult gameResult = new GameResult(winningNumbers);
        gameResult.record(Arrays.asList(new Lotto(matchNumbers)));

        assertThat(gameResult.totalPrizeMoney())
                .isEqualTo(Rank.FORTH.totalPrizeMoney(1));
    }

    @Test
    public void 당첨번호_4개_매칭() {
        List<String> winningNumbers = Arrays.asList("1", "2", "3", "4", "5", "6");
        List<String> matchNumbers = Arrays.asList("1", "2", "3", "4", "8", "9");

        GameResult gameResult = new GameResult(winningNumbers);
        gameResult.record(Arrays.asList(new Lotto(matchNumbers)));

        assertThat(gameResult.totalPrizeMoney())
                .isEqualTo(Rank.THIRD.totalPrizeMoney(1));
    }

    @Test
    public void record_테스트() {
        List<String> winningNumbers = Arrays.asList("1", "2", "3", "4", "5", "6");
        GameResult gameResult = new GameResult(winningNumbers);

        gameResult.record(Arrays.asList(new Lotto(winningNumbers)));
        int matchCount = gameResult.getRank().get(Rank.FIRST);

        assertThat(matchCount)
                .isEqualTo(1);
    }

    @Test
    public void 당첨금_1등() {
        List<String> winningNumbers = Arrays.asList("1", "2", "3", "4", "5", "6");
        GameResult gameResult = new GameResult(winningNumbers);
        gameResult.record(Arrays.asList(new Lotto(winningNumbers)));

        long totalPrizeMoney = gameResult.totalPrizeMoney();

        assertThat(totalPrizeMoney)
                .isEqualTo(2_000_000_000);
    }

    @Test
    public void 수익률() {
        List<String> winningNumbers = Arrays.asList("1", "2", "3", "4", "5", "6");
        List<String> numbers = Arrays.asList("1", "2", "3", "7", "8", "9");
        GameResult gameResult = new GameResult(winningNumbers);
        gameResult.record(Arrays.asList(new Lotto(numbers)));
        int amount = 14_000;

        int actual = gameResult.rateOfReturn(amount);

        assertThat(actual)
                .isEqualTo(35);
    }
}