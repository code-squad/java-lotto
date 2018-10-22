package domain;

import domaim.Reward;
import org.junit.Test;
import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;


public class RewardTest {

    @Test
    public void getSumTest() {
        Map<Integer, Integer> rewardResult = new HashMap<>();
        rewardResult.put(3, 1); // 5000
        rewardResult.put(4, 2); // 100000
        assertThat(Reward.getSum(rewardResult)).isEqualTo(105000);
    }

    @Test
    public void calculateProfit() {
        Map<Integer, Integer> rewardResult = new HashMap<>();
        rewardResult.put(3, 1); // 5000
        assertThat(Reward.calculateProfit(10000, rewardResult)).isEqualTo(50);
    }
}
