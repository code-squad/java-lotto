package Controller;

import domain.*;
import dto.LottoDto;
import dto.RewardDto;
import view.InputView;
import view.ResultView;

public class LottoController {
    public static void main(String[] args) {
        LottoGame lottoGame = new LottoGame(InputView.getPay());
        LottoDto lottoDto = lottoGame.createLottoDto();
        ResultView.showLottoNum(lottoDto);
        ResultView.showLottoList(lottoDto);

        lottoGame.matchAllLottoResult(LottoFactory.createWinningLotto(InputView.getWinningNum(), InputView.getBonusBall()));
        RewardDto rewardDto = lottoGame.createRewardDto();
        ResultView.showWinStats(rewardDto);
        ResultView.showProfit(rewardDto);
    }
}