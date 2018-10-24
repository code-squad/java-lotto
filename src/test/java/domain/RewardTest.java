package domain;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;


public class RewardTest {

    @Test
    public void getSumTest() {
        Map<Reward, Integer> rewardResult = new HashMap<>();
        rewardResult.put(Reward.REWARD_FIFTH, 2);
        assertThat(Reward.calculateSum(rewardResult)).isEqualTo(10000);
    }

    @Test
    public void calculateProfitTest() {
        Map<Reward, Integer> rewardResult = new HashMap<>();
        rewardResult.put(Reward.REWARD_FIFTH, 2);
        assertThat(Reward.calculateProfit(1000, rewardResult)).isEqualTo(1000);
    }
}
