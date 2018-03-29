package domain;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class LottosTest {

    @Test
    public void 맞춘로또수_3개() {
        Lottos lottos = Lottos.of();
        lottos.addLottosManual(Arrays.asList(1, 2, 3, 4, 5, 6)); // 2
        lottos.addLottosManual(Arrays.asList(1, 2, 3, 4, 5, 7)); // 3
        lottos.addLottosManual(Arrays.asList(1, 2, 3, 4, 5, 8)); // 2
        List<Integer> answer = Arrays.asList(4, 5, 7, 10, 11, 12);
        assertThat(1, is(lottos.getMatchLottos(answer, 3)));
    }

    @Test
    public void 맞춘로또수_4개() {
        Lottos lottos = Lottos.of();
        lottos.addLottosManual(Arrays.asList(1, 2, 3, 4, 5, 6));  // 2
        lottos.addLottosManual(Arrays.asList(1, 15, 7, 4, 5, 8)); // 4
        lottos.addLottosManual(Arrays.asList(1, 2, 7, 4, 5, 8));  // 4
        List<Integer> answer = Arrays.asList(4, 5, 7, 8, 11, 12);
        assertThat(2, is(lottos.getMatchLottos(answer, 4)));
    }

    @Test
    public void 맞춘로또수_5개() {
        Lottos lottos = Lottos.of();
        lottos.addLottosManual(Arrays.asList(1, 2, 3, 4, 5, 9)); // 5
        lottos.addLottosManual(Arrays.asList(1, 2, 3, 4, 5, 10)); // 5
        lottos.addLottosManual(Arrays.asList(1, 2, 3, 4, 5, 11)); // 5
        List<Integer> answer = Arrays.asList(1, 2, 3, 4, 5, 6);
        assertThat(3, is(lottos.getMatchLottos(answer, 5)));
    }

    @Test
    public void 맞춘로또수_6개() {
        Lottos lottos = Lottos.of();
        lottos.addLottosManual(Arrays.asList(1, 2, 3, 4, 5, 6)); // 6
        lottos.addLottosManual(Arrays.asList(1, 2, 3, 4, 5, 7)); // 5
        lottos.addLottosManual(Arrays.asList(1, 2, 3, 4, 5, 8)); // 5
        List<Integer> answer = Arrays.asList(1, 2, 3, 4, 5, 6);
        assertThat(1, is(lottos.getMatchLottos(answer, 6)));
    }

    @Test
    public void 최종결과반환() {
        Lottos lottos = Lottos.of();
        lottos.addLottosManual(Arrays.asList(1, 2, 3, 4, 5, 6));
        lottos.addLottosManual(Arrays.asList(2, 3, 4, 5, 6, 7));
        lottos.addLottosManual(Arrays.asList(3, 4, 6, 7, 8, 9));

        /*
         * 3개 -> 2
         * 4개 -> 1
         * 5개 -> 0
         * 6개 -> 0
         * */

        List<Integer> answer = Arrays.asList(1, 2, 3, 7, 8, 9);
        List<Integer> expected = Arrays.asList(2, 1, 0, 0);
        assertThat(expected, is(lottos.getResult(answer)));
    }

    @Test
    public void 수익률계산() {
        Lottos lottos = Lottos.of();
        lottos.addLottosManual(Arrays.asList(1, 2, 3, 4, 5, 6));
        lottos.addLottosManual(Arrays.asList(2, 3, 4, 5, 6, 7));
        lottos.addLottosManual(Arrays.asList(3, 4, 6, 7, 8, 9));

        /*
         * 3개 -> 2
         * 4개 -> 1
         * 5개 -> 0
         * 6개 -> 0
         * */

        List<Integer> answer = Arrays.asList(1, 2, 3, 7, 8, 9);
        List<Integer> expected = Arrays.asList(2, 1, 0, 0);
        assertThat(1900, is(lottos.calcProfit(answer)));
    }

    @Test
    public void 구입로또출력() {
        Lottos lottos = Lottos.of();
        lottos.addLottosManual(Arrays.asList(1, 2, 3, 4, 5, 6));
        lottos.addLottosManual(Arrays.asList(2, 3, 4, 5, 6, 7));
        String expected = "1,2,3,4,5,6\n2,3,4,5,6,7";
        assertThat(expected, is(lottos.toString()));
    }

}
