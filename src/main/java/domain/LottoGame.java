package domain;

import dto.LottoDto;
import dto.RewardDto;

import java.util.*;

public class LottoGame {
    private static final int LOTTO_PRICE = 1000;
    private static final int POSSIBLE_WIN_NUM = 3;
    private Map<Reward, Integer> rewardResult = new TreeMap<>(Collections.reverseOrder());
    private List<Lotto> lottos = new ArrayList<>();

    public LottoGame(int pay) {
        buyLottos(pay);
        initRewardResult();
    }

    private void initRewardResult() {
        for(int rank = Lotto.LOTTO_NUMBER_COUNT - 1; rank > 0; rank--) {
            rewardResult.put(Reward.obtainReward(rank), 0);
        }
    }

    /* 가격에 맞게 구매할 수 있는 로또 갯수 구하는 메소드 */
    public static int countGameNum(int pay) {
        return pay / LOTTO_PRICE;
    }

    /* 모든 로또에 대한 결과를 확인하는 메소드 */
    public void matchAllLottoResult(WinningLotto winningLotto) {
        for(Lotto lotto : lottos) {
           addRewardResult(matchLottoResult(lotto, winningLotto));
        }
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

    /* 로또 결과 확인을 위한 메소드로서, 리턴값은 enum type LottoResult */
    public static Reward matchLottoResult(Lotto lotto, WinningLotto winningLotto) {
        return winningLotto.obtainReward(lotto);
    }

    /* 가격에 맞게 로또를 구매하는 메소드 */
    private void buyLottos(int pay) {
        for(int i = 0; i < countGameNum(pay); i++) {
            lottos.add(LottoFactory.createLotto());
        }
    }

    /* 결과값을 가지고 있는 LottoDto 생성 */
    public LottoDto createLottoDto() {
        return new LottoDto(lottos);
    }

    public RewardDto createRewardDto() {
        return new RewardDto(Reward.calculateProfit(getPay(), rewardResult), rewardResult);
    }

    private int getPay() {
        return lottos.size() * LOTTO_PRICE;
    }
}
