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
        int pay = InputView.getPay();
        LottoGame lottoGame = new LottoGame(pay, InputView.getHandOperatedLotto(InputView.getHandOperated(pay)));
        LottoDto lottoDto = lottoGame.createLottoDto();
        ResultView.showPurchaseReport(lottoDto);
        ResultView.showLottoList(lottoDto);

        lottoGame.matchAllLottoResult(LottoFactory.createWinningLotto(InputView.getWinningNum(), InputView.getBonusBall()));
        RewardDto rewardDto = lottoGame.createRewardDto();
        ResultView.showWinStats(rewardDto);
        ResultView.showProfit(rewardDto);
    }
}