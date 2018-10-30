package domain;

import dto.RewardDto;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class RewardResult {

    private static final int POSSIBLE_WIN_NUM = 3;
    private Map<Reward, Integer> rewardResult = new TreeMap<>(Collections.reverseOrder());

    public RewardResult() {
        initRewardResult();
    }

    private void initRewardResult() {
        /* 스트림 적용 전 --> */
        /*for(int rank = Lotto.LOTTO_NUMBER_COUNT - 1; rank > 0; rank--) {
            rewardResult.put(Reward.obtainReward(rank), 0);
        }*/
        IntStream.range(1, Lotto.LOTTO_NUMBER_COUNT)
                .forEach(rank -> rewardResult.put(Reward.obtainReward(rank), 0));
    }

    public void addRewardResult(Reward reward) {
        int value = 1;
        if(rewardResult.containsKey(reward)) {
            value = rewardResult.get(reward) + 1;
        }
        if(isPossibleWinNumber(reward)) {
            rewardResult.put(reward, value);
        }
    }

    /*  3개 미만으로 맞힌 로또는 결과를 저장할 필요가 없기 때문에 3개 미만 체크하는 메소드 */
    private boolean isPossibleWinNumber(Reward reward) {
        if (reward.obtainLottoHit() < POSSIBLE_WIN_NUM) {
            return false;
        }
        return true;
    }

    /* 총 수익의 총합을 곅산하는 메소드 */
    public int calculateSum() {
        /* 스트림 적용 전 --> */
        /*int sum = 0;
        Iterator<Reward> it = rewardResult.keySet().iterator();
        while(it.hasNext()) {
            Reward reward = it.next();
            sum += (reward.obtainPrize() *  rewardResult.get(reward));
        }
        return sum;*/
        return rewardResult.keySet()
                .stream()
                .mapToInt(reward -> (reward.obtainPrize() *  rewardResult.get(reward))).sum();
    }

    /* 수익률 계산하는 메소드 */
    public int calculateProfit(int purchaseMoney) {
        return (int)((double) calculateSum() / purchaseMoney * 100);
    }

    public RewardDto createRewardDto(int purchaseMoney) {
        return new RewardDto(calculateProfit(purchaseMoney), rewardResult);
    }
}
