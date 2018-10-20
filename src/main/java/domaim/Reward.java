package domaim;

import dto.RewardDto;

import java.util.*;

public class Reward {
    private static Map<Integer, Integer> rewardMapper;
    private static final int POSSIBLE_WIN_NUM = 3;
    private Map<Integer, Integer> rewardResult;
    private Lotto winningNumbers;

    /* 당첨에 따른 보상 초기화 메소드 */
    static {
        rewardMapper = new HashMap<>();
        rewardMapper.put(3, 5000);
        rewardMapper.put(4, 50000);
        rewardMapper.put(5, 1500000);
        rewardMapper.put(6, 2000000000);
    }

    public Reward(Lotto winningNumbers) {
        this.winningNumbers = winningNumbers;
        this.rewardResult = new HashMap<>();

        initRewardResult();
    }

    private void initRewardResult() {
        for(int i = POSSIBLE_WIN_NUM; i <= Lotto.LOTTO_NUMBER_COUNT; i++) {
            rewardResult.put(i, 0);
        }
    }

    /* 3개 이상 맞힌 로또의 결과만 로또 결과를 저장하는 Map에 저장하는 메소드 */
    public void addRewardResult(Lotto lotto) {
        int key = matchLotto(lotto);
        if(!isPossibleWinNumber(key)) {
            /* 질문1) 이렇게 써도 되나요? continue나 break와 비슷하기 때문에 권장을 안 하시죠? */
            return;
        }
        int value = 1;
        if(rewardResult.containsKey(key)) {
            value = rewardResult.get(key) + 1;
        }
        rewardResult.put(key, value);
    }

    /*  3개 미만으로 맞힌 로또는 결과를 저장할 필요가 없기 때문에 3개 미만 체크하는 메소드 */
    private boolean isPossibleWinNumber(int num) {
        if(num < POSSIBLE_WIN_NUM) {
            return false;
        }
        return true;
    }

    /* 로또 번호가 맞는지 확인하는 메소드
     *    --> 포함할때만 더하는 경우이기 때문에.. 2depth가 존재...  */
    public int matchLotto(Lotto lotto) {
        int cnt = 0;
        for(int i = 0; i < Lotto.LOTTO_NUMBER_COUNT; i++) {
            cnt = winningNumbers.isContainNumber(lotto, i) ? cnt + 1 : cnt;
        }
        return cnt;
    }

    /* 수익률 계산하는 메소드 */
    public int calculateProfit(int pay) {
        return getSum() / pay;
    }

    /* 총 수익의 값을 곅산하는 메소드 */
    public int getSum() {
        int sum = 0;
        Iterator<Integer> it = rewardResult.keySet().iterator();
        while(it.hasNext()) {
            int key = it.next();
            sum += (rewardMapper.get(key) *  rewardResult.get(key));
        }
        return sum;
    }

    /* Reward가 결과값을 가지고 있느냐? --> 구매목록을 Reward에 넘겨야하고,
       LottoGame이 결과값을 가지고 있느냐? --> 당첨내용을 LottoGame에 넘겨야하고, */
    public RewardDto createRewardDto(int pay) {
        return new RewardDto(calculateProfit(pay), rewardResult, rewardMapper);
    }
}
