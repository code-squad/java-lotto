package lotto.domain;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.assertj.core.api.Assertions.assertThat;


public class RankTest {
    @Test
    public void rank_Test() {
//        assertThat(Rank.valueOf(5, false)).isEqualTo(Rank.THIRD);
        Rank.valueOf(5, false);
    }
}