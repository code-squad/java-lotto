package domain;

import dto.RewardDto;

import java.util.*;

public enum Reward {
    FIRST_REWARD(LottoResult.FIRST, 2000000000), SECOND_REWARD(LottoResult.SECOND, 30000000),
    THIRD_REWARD(LottoResult.THIRD, 1500000), FOURTH_REWARD(LottoResult.FOURTH, 50000),
    REWARD_FIFTH(LottoResult.FIFTH, 5000), REWARD_NONE(LottoResult.NONE, 0);

    private int prizeMoney;
    private LottoResult lottoResult;

    Reward(LottoResult lottoResult, int prizeMoney) {
        this.lottoResult = lottoResult;
        this.prizeMoney = prizeMoney;
    }

    /* 총 수익의 총합을 곅산하는 메소드 */
    public static int calculateSum(Map<Reward, Integer> rewardResult) {
        int sum = 0;
        Iterator<Reward> it = rewardResult.keySet().iterator();
        while(it.hasNext()) {
            Reward key = it.next();
            sum += (getPrize(key) *  rewardResult.get(key));
        }
        return sum;
    }

    /* 로또 결과에 대한 상금을 얻는 메소드 (예: 5등 : 5000원) */
    public static int getPrize(Reward targetReward) {
        for(Reward reward : values()) {
            if(reward == targetReward) {
                return reward.prizeMoney;
            }
        }
        return 0;
    }

    /* 수익률 계산하는 메소드 */
    public static int calculateProfit(int pay, Map<Reward, Integer> rewardResult) {
        return (int)((double) calculateSum(rewardResult) / pay * 100);
    }

    public static Reward obtainReward(int rank) {
        for(Reward reward : values()) {
            if(reward.ordinal() + 1 == rank) {
                return reward;
            }
        }
        return Reward.REWARD_NONE;
    }

    public static Reward obtainReward(LottoResult lottoResult) {
        for(Reward reward : values()) {
            if(reward.lottoResult == lottoResult) {
                return reward;
            }
        }
        return Reward.REWARD_NONE;
    }

    public static int getLottoHit(Reward targetReward) {
        for(Reward reward : values()) {
            if(reward == targetReward) {
                return LottoResult.obtainLottoHit(reward.lottoResult);
            }
        }
        return LottoResult.obtainLottoHit(REWARD_NONE.lottoResult);
    }

    public static int getBonuisHit(Reward targetReward) {
        for(Reward reward : values()) {
            if(reward == targetReward) {
                return LottoResult.obtainBonusHit(reward.lottoResult);
            }
        }
        return LottoResult.obtainBonusHit(REWARD_NONE.lottoResult);
    }

    public static boolean isSecond(Reward targetReward) {
        return LottoResult.obtainLottoResult(Reward.getLottoHit(targetReward), Reward.getBonuisHit(targetReward)) == LottoResult.SECOND;
    }
}
