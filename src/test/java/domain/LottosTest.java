package domain;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class LottosTest {
    Lottos lottos;


//    @Test
//    public void 맞춘로또수_3개() {
//        lottos = Lottos.of();
//        lottos.addLottosManual(Arrays.asList(1, 2, 3, 4, 5, 6)); // 2
//        lottos.addLottosManual(Arrays.asList(1, 2, 3, 4, 5, 7)); // 3
//        lottos.addLottosManual(Arrays.asList(1, 2, 3, 4, 5, 8)); // 2
//        Lotto winningLotto = Lotto.of(Arrays.asList(4, 5, 7, 10, 11, 12));
//        assertThat(1, is(lottos.getMatchLottos(winningLotto, 3)));
//    }
//
//    @Test
//    public void 맞춘로또수_4개() {
//        lottos = Lottos.of();
//        lottos.addLottosManual(Arrays.asList(1, 2, 3, 4, 5, 6));  // 2
//        lottos.addLottosManual(Arrays.asList(1, 15, 7, 4, 5, 8)); // 4
//        lottos.addLottosManual(Arrays.asList(1, 2, 7, 4, 5, 8));  // 4
//        Lotto winningLotto = Lotto.of(Arrays.asList(4, 5, 7, 8, 11, 12));
//        assertThat(2, is(lottos.getMatchLottos(winningLotto, 4)));
//    }
//
//    @Test
//    public void 맞춘로또수_5개() {
//        lottos = Lottos.of();
//        lottos.addLottosManual(Arrays.asList(1, 2, 3, 4, 5, 9)); // 5
//        lottos.addLottosManual(Arrays.asList(1, 2, 3, 4, 5, 10)); // 5
//        lottos.addLottosManual(Arrays.asList(1, 2, 3, 4, 5, 11)); // 5
//        Lotto winningLotto = Lotto.of(Arrays.asList(1, 2, 3, 4, 5, 6));
//        assertThat(3, is(lottos.getMatchLottos(winningLotto, 5)));
//    }
//
//    @Test
//    public void 맞춘로또수_6개() {
//        lottos = Lottos.of();
//        lottos.addLottosManual(Arrays.asList(1, 2, 3, 4, 5, 6)); // 6
//        lottos.addLottosManual(Arrays.asList(1, 2, 3, 4, 5, 7)); // 5
//        lottos.addLottosManual(Arrays.asList(1, 2, 3, 4, 5, 8)); // 5
//        Lotto winningLotto = Lotto.of(Arrays.asList(1, 2, 3, 4, 5, 6));
//        assertThat(1, is(lottos.getMatchLottos(winningLotto, 6)));
//    }

    @Test
    public void 랭크결과배열출력() {
        lottos = Lottos.of();
        lottos.addLottosManual(Arrays.asList(1, 2, 3, 7, 8, 9)); // FIRST
        lottos.addLottosManual(Arrays.asList(1, 2, 3, 7, 8, 10)); // SECOND
        lottos.addLottosManual(Arrays.asList(1, 2, 3, 7, 5, 14)); // FORTH
        lottos.addLottosManual(Arrays.asList(1, 2, 3, 7, 5, 15)); // FORTH

        /*
         * prize result;
         * FIRST -> 1
         * SECOND -> 1
         * THIRD -> 0
         * FORTH -> 2
         * FIFTH -> 0
         *
         * */

        WinningLotto winningLotto = WinningLotto.of(Arrays.asList(1, 2, 3, 7, 8, 9), Number.of(10));
        List<Rank> expected = Arrays.asList(Rank.FIRST, Rank.SECOND, Rank.FOURTH, Rank.FOURTH);
        assertThat(expected, is(lottos.getLottoRanks(winningLotto)));
    }


    @Test
    public void 최종결과반환() {
        lottos = Lottos.of();
        lottos.addLottosManual(Arrays.asList(1, 2, 3, 7, 8, 9)); // FIRST
        lottos.addLottosManual(Arrays.asList(1, 2, 3, 7, 8, 10)); // SECOND
        lottos.addLottosManual(Arrays.asList(1, 2, 3, 7, 5, 14)); // FORTH
        lottos.addLottosManual(Arrays.asList(1, 2, 3, 7, 5, 15)); // FORTH

        /*
         * prize result;
         * FIRST -> 1
         * SECOND -> 1
         * THIRD -> 0
         * FORTH -> 2
         * FIFTH -> 0
         *
         * */

        WinningLotto winningLotto = WinningLotto.of(Arrays.asList(1, 2, 3, 7, 8, 9), Number.of(10));
        List<Integer> expected = Arrays.asList(1, 1, 0, 2, 0);
        assertThat(expected, is(lottos.getResult(winningLotto)));
    }

//    @Test
//    public void 수익률계산() {
//        Lottos lottos = Lottos.of();
//        lottos.addLottosManual(Arrays.asList(1, 2, 3, 4, 5, 6));
//        lottos.addLottosManual(Arrays.asList(2, 3, 4, 5, 6, 7));
//        lottos.addLottosManual(Arrays.asList(3, 4, 6, 7, 8, 9));
//
//        /*
//         * 3개 -> 2
//         * 4개 -> 1
//         * 5개 -> 0
//         * 6개 -> 0
//         * */
//
//        Lotto winningLotto = Lotto.of(Arrays.asList(1, 2, 3, 7, 8, 9));
//        assertThat(1900, is(lottos.calcProfit(winningLotto)));
//    }

    @Test
    public void 구입로또출력() {
        Lottos lottos = Lottos.of();
        lottos.addLottosManual(Arrays.asList(1, 2, 3, 4, 5, 6));
        lottos.addLottosManual(Arrays.asList(2, 3, 4, 5, 6, 7));
        String expected = "1,2,3,4,5,6\n2,3,4,5,6,7";
        assertThat(expected, is(lottos.toString()));
    }



}
