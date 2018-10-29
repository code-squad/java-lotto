package Controller;

import domain.*;
import dto.LottoDto;
import dto.RewardDto;
import jdk.internal.util.xml.impl.Input;
import view.InputView;
import view.ResultView;

import java.util.List;

public class LottoController {
    public static void main(String[] args) {
        PurchaseMoney purchaseMoney = InputView.getPay();
        LottoGame lottoGame = new LottoGame(purchaseMoney,
                InputView.getHandOperatedLotto(InputView.getHandOperated(purchaseMoney)));
        LottoDto lottoDto = lottoGame.createLottoDto();
        ResultView.showPurchaseReport(lottoDto);
        ResultView.showLottoList(lottoDto);

        lottoGame.matchAllLottoResult(LottoFactory.createWinningLotto(InputView.getWinningNum(), InputView.getBonusBall()));
        RewardDto rewardDto = lottoGame.createRewardDto();
        ResultView.showWinStats(rewardDto);
        ResultView.showProfit(rewardDto);
    }
}