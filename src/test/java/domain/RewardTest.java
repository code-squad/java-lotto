package domain;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;


public class RewardTest {

    @Test
    public void isSecondTest() {
        assertThat(Reward.isSecond(5, true)).isEqualTo(Reward.SECOND_REWARD);
    }

    @Test
    public void obtainRewardByRankTest() {
        assertThat(Reward.obtainReward(1)).isEqualTo(Reward.FIRST_REWARD);
    }

    @Test
    public void obtainRewardByHitTest() {
        assertThat(Reward.obtainReward(6, true)).isEqualTo(Reward.FIRST_REWARD);
        assertThat(Reward.obtainReward(5, true)).isEqualTo(Reward.SECOND_REWARD);
        assertThat(Reward.obtainReward(5, false)).isEqualTo(Reward.THIRD_REWARD);
        assertThat(Reward.obtainReward(2, true)).isEqualTo(Reward.NONE_REWARD);
    }
}
