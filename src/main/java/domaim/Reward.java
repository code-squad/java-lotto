package domaim;

import java.util.*;

public class Reward {
    public static final Map<Integer, Integer> rewardMapper = new HashMap<>();

    /* 당첨에 따른 보상 초기화 메소드 */
    static {
        rewardMapper.put(3, 5000);
        rewardMapper.put(4, 50000);
        rewardMapper.put(5, 1500000);
        rewardMapper.put(6, 2000000000);
    }

    /* 수익률 계산하는 메소드 */
    public static int calculateProfit(int pay, Map<Integer, Integer> rewardResult) {
        return (int)((double)getSum(rewardResult) / pay * 100);
    }

    /* 총 수익의 값을 곅산하는 메소드 */
    public static int getSum(Map<Integer, Integer> rewardResult) {
        int sum = 0;
        Iterator<Integer> it = rewardResult.keySet().iterator();
        while(it.hasNext()) {
            int key = it.next();
            sum += (rewardMapper.get(key) *  rewardResult.get(key));
        }
        return sum;
    }
}
