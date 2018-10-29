package domain;

import dto.RewardDto;

import java.util.*;

public enum Reward {
    /*  피드백1-2) 로또번호와 보너스번호의 정보를 매핑하는 LottoResult enum과 합쳐서 관리하는 것이 좋지 않을까? --> 하나로 통합 권장!*/
    FIRST_REWARD(6, false, 2000000000), SECOND_REWARD(5, true, 30000000),
    THIRD_REWARD(5, false, 1500000), FOURTH_REWARD(4, false, 50000),
    REWARD_FIFTH(3, false, 5000), REWARD_NONE(0, false, 0);

    private int lottoHit;
    private boolean bonusHit;
    private int prizeMoney;

    Reward(int lottoHit, boolean bonusHit, int prizeMoney) {
        this.lottoHit = lottoHit;
        this.bonusHit = bonusHit;
        this.prizeMoney = prizeMoney;
    }

    /* 순위를 통해 Reward객체를 반환하는 메소드 */
    public static Reward obtainReward(int rank) {
        for(Reward reward : values()) {
            if(reward.ordinal() + 1 == rank) {
                return reward;
            }
        }
        return Reward.REWARD_NONE;
    }

    /* 로또 정중수, 보너스볼 결과에 따라 Reward 객체를 반환하는 메소드 */
    public static Reward obtainReward(int lottoHit, boolean bonusHit) {
        for(Reward reward : values()) {
            if(isSecond(lottoHit, bonusHit)) {
                return Reward.SECOND_REWARD;
            }
            if(reward.lottoHit == lottoHit) {
                return reward;
            }
        }
        return Reward.REWARD_NONE;
    }

    public static boolean isSecond(int lottoHit, boolean bonusHit) {
        return Reward.SECOND_REWARD.bonusHit == bonusHit && Reward.SECOND_REWARD.lottoHit == lottoHit;
    }

    public boolean isSecond() {
        return Reward.SECOND_REWARD == this;
    }

    public int obtainLottoHit() {
        return this.lottoHit;
    }

    /* 로또 결과에 대한 상금을 얻는 메소드 (예: 5등 : 5000원) */
    public int obtainPrize() {
        return this.prizeMoney;
    }
}
