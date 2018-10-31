package domain;

import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class matchRankTest {

    @Test
    public void 카운트() {
        LottoryManager lottoryManager = LottoryManager.of(1000);
        // 4등의 카운트를 증가 시켰다.
        lottoryManager.increase(4, true);
        assertThat(lottoryManager.findRank(Rank.ONE)).isEqualTo(0);
        assertThat(lottoryManager.findRank(Rank.TWO)).isEqualTo(0);
        assertThat(lottoryManager.findRank(Rank.THREE)).isEqualTo(0);
        assertThat(lottoryManager.findRank(Rank.FOUR)).isEqualTo(1);
        assertThat(lottoryManager.findRank(Rank.FIVE)).isEqualTo(0);

    }

    @Test
    public void 일등() {
        Arrays.stream(Rank.values()).filter(value -> value.matchNum(6, true)).forEach(System.out::println);
        Arrays.stream(Rank.values()).filter(value -> value.matchNum(6, false)).forEach(System.out::println);

    }

    @Test
    public void 이등삼등() {
        Arrays.stream(Rank.values()).filter(value -> value.matchNum(5, true)).forEach(System.out::println);
        Arrays.stream(Rank.values()).filter(value -> value.matchNum(5, false)).forEach(System.out::println);

    }

    @Test
    public void 나머지() {
        Arrays.stream(Rank.values()).filter(value -> value.matchNum(4, true)).forEach(System.out::println);
        Arrays.stream(Rank.values()).filter(value -> value.matchNum(4, false)).forEach(System.out::println);

        Arrays.stream(Rank.values()).filter(value -> value.matchNum(3, true)).forEach(System.out::println);
        Arrays.stream(Rank.values()).filter(value -> value.matchNum(3, false)).forEach(System.out::println);
    }

}
