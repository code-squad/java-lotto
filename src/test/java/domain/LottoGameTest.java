package domain;

import org.junit.Test;
import utils.Rank;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoGameTest {

    @Test(expected = IllegalArgumentException.class)
    public void winningLotto_보너스_범위_밖() {
        new WinningLotto(Arrays.asList(1, 2, 3, 4, 5, 6), 47);
    }

    @Test(expected = IllegalArgumentException.class)
    public void winningLotto_보너스_로또_중복수() {
        new WinningLotto(Arrays.asList(1, 2, 3, 4, 5, 6), 6);
    }

    @Test (expected = IllegalArgumentException.class)
    public void WinningLotto_만들때_super받는_로또값_유효성체크_중복() {
        new WinningLotto(Arrays.asList(1, 2, 3, 5, 5, 45), 6);
    }

    @Test (expected = IllegalArgumentException.class)
    public void WinningLotto_만들때_super받는_로또값_유효성체크_범위_초과() {
        new WinningLotto(Arrays.asList(1, 2, 3, 5, 5, 47), 6);
    }

    @Test (expected = IllegalArgumentException.class)
    public void WinningLotto_만들때_super받는_로또값_유효성체크_수_초과() {
        new WinningLotto(Arrays.asList(1, 2, 3, 5, 5, 45, 13), 6);
    }

    @Test
    public void HashMap_Value값_증감_Test() {
        Map<Rank, Integer> map = new HashMap<>();
        map.put(Rank.FIRST, 3);

        int count = map.get(Rank.FIRST);
        map.put(Rank.FIRST, count + 1);

        assertThat(map.get(Rank.FIRST)).isEqualTo(4);
    }

    @Test
    public void HashMap_키가_없는값이면_반환값() {
        Map<Rank, Integer> map = new HashMap<>();
        map.put(Rank.FIRST, 0);

//        assertThat(map.get(Rank.SECOND)).isEqualTo(null);
        assertThat(map.get(Rank.SECOND) == null).isEqualTo(true);
    }


}