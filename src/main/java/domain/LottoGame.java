package domain;

import dto.LottoDto;
import dto.RewardDto;

import java.util.*;


public class LottoGame {
    private List<Lotto> autoLottos = new ArrayList<>();
    private List<Lotto> handOperatedLottos;
    private RewardMoney rewardMoney;

    public LottoGame(PurchaseMoney purchaseMoney, List<Lotto> handOperatedLottos) {
        this.handOperatedLottos = handOperatedLottos;
        buyLottos(purchaseMoney);
        rewardMoney = new RewardMoney();
    }

    /* 모든 로또에 대한 결과를 확인하는 메소드 */
    public void matchAllLottoResult(WinningLotto winningLotto) {
        autoLottos.addAll(handOperatedLottos);
        for(Lotto lotto : autoLottos) {
           addRewardResult(matchLottoResult(lotto, winningLotto));
        }
    }

    public void addRewardResult(Reward reward) {
        rewardMoney.addRewardResult(reward);
    }

    /* 로또 결과 확인을 위한 메소드로서, 리턴값은 enum type LottoResult */
    public static Reward matchLottoResult(Lotto lotto, WinningLotto winningLotto) {
        return winningLotto.obtainReward(lotto);
    }

    /* 가격에 맞게 로또를 구매하는 메소드 */
    private void buyLottos(PurchaseMoney purchaseMoney) {
        for(int i = 0; i < purchaseMoney.countGame(handOperatedLottos.size()); i++) {
            autoLottos.add(LottoFactory.createLotto());
        }
    }

    /* 결과값을 가지고 있는 LottoDto 생성 */
    public LottoDto createLottoDto() {
        return new LottoDto(autoLottos, handOperatedLottos);
    }

    public RewardDto createRewardDto() {
        return rewardMoney.createRewardDto(getPurchaseMoney());
    }

    private int getPurchaseMoney() {
        return (autoLottos.size() + handOperatedLottos.size()) * PurchaseMoney.LOTTO_PRICE;
    }
}
