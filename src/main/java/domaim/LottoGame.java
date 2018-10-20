package domaim;

import dto.LottoDto;
import dto.RewardDto;

import java.util.*;

public class LottoGame {
    public static final int LOTTO_PRICE = 1000;
    private List<Lotto> lottos;
    private int pay;
    private int gameNum;

    public LottoGame() {
        lottos = new ArrayList<>();
    }

    public LottoGame(int pay) {
        this();
        this.pay = pay;
        this.gameNum = countGameNum(pay);
        buyLottos();
    }

    /* 가격에 맞게 구매할 수 있는 로또 갯수 구하는 메소드 */
    public int countGameNum(int pay) {
        return pay / LOTTO_PRICE;
    }

    /* 가격에 맞게 로또를 구매하는 메소드 */
    public void buyLottos() {
        for(int i = 0; i < gameNum; i++) {
            lottos.add(LottoFactory.createLotto());
        }
    }

    /* 로또와 결과값을 비교하는 메소드 */
    public void setLottoReward(Reward reward) {
        for(Lotto lotto : lottos) {
            reward.addRewardResult(lotto);
        }
    }

    /* 결과값을 가지고 있는 LottoDto 생성 */
    public LottoDto createLottoDto() {
        return new LottoDto(lottos);
    }

    /* 결과값을 가지고 있는 RewardDto 생성 */
    public RewardDto createRewardDto(Reward reward) {
        return reward.createRewardDto(pay);
    }
}
