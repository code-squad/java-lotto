package domaim;

import dto.LottoDto;
import dto.RewardDto;

import java.util.*;

public class LottoGame {
    private static final int LOTTO_PRICE = 1000;
    private static final int POSSIBLE_WIN_NUM = 3;
    private List<Lotto> lottos;

    public LottoGame(int pay) {
        this.lottos = new ArrayList<>();
        buyLottos(pay);
    }

    /* 가격에 맞게 구매할 수 있는 로또 갯수 구하는 메소드 */
    public static int countGameNum(int pay) {
        return pay / LOTTO_PRICE;
    }

    /* 가격에 맞게 로또를 구매하는 메소드 */
    private void buyLottos(int pay) {
        for(int i = 0; i < countGameNum(pay); i++) {
            lottos.add(LottoFactory.createLotto());
        }
    }

    /* 로또와 결과값을 비교하는 메소드 */
    public Map<Integer, Integer> compareLottoRewardResult(Lotto winningLotto) {
        Map<Integer, Integer> rewardResult = initRewardResult();
        for(Lotto lotto : lottos) {
            addRewardResult(lotto, winningLotto, rewardResult);
        }
        return rewardResult;
    }

    /* 결과값을 가지고 있는 LottoDto 생성 */
    public LottoDto createLottoDto() {
        return new LottoDto(lottos);
    }

    private Map<Integer, Integer> initRewardResult() {
        Map<Integer, Integer> rewardResult = new HashMap<>();
        for(int i = POSSIBLE_WIN_NUM; i <= Lotto.LOTTO_NUMBER_COUNT; i++) {
            rewardResult.put(i, 0);
        }
        return rewardResult;
    }

    /* 3개 이상 맞힌 로또의 결과만 로또 결과를 저장하는 Map에 저장하는 메소드 */
    public void addRewardResult(Lotto lotto, Lotto winnigLotto, Map<Integer, Integer> rewardResult) {
        int key = lotto.matchLotto(winnigLotto);
        if(rewardResult.containsKey(key) && isPossibleWinNumber(key)) {
            rewardResult.put(key, rewardResult.get(key) + 1);
        }
    }

    /*  3개 미만으로 맞힌 로또는 결과를 저장할 필요가 없기 때문에 3개 미만 체크하는 메소드 */
    private boolean isPossibleWinNumber(int num) {
        if(num < POSSIBLE_WIN_NUM) {
            return false;
        }
        return true;
    }

    /* 결과값을 가지고 있는 RewardDto 생성 */
    public RewardDto createRewardDto(Lotto winnigLotto) {
        return new RewardDto(Reward.calculateProfit(getPay(), compareLottoRewardResult(winnigLotto))
                ,compareLottoRewardResult(winnigLotto), Reward.rewardMapper); // 상수라서 다음과 같이 구현했는데... 비권장이죠??
    }

    private int getPay() {
        return lottos.size() * LOTTO_PRICE;
    }
}
