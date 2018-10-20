package Controller;

import domaim.LottoGame;
import domaim.Reward;
import dto.LottoDto;
import dto.RewardDto;
import view.InputView;
import view.ResultView;

public class LottoController {
    public static void main(String[] args)  {
        LottoGame lottoGame = new LottoGame(InputView.getPay());
        LottoDto lottoDto = lottoGame.createLottoDto();
        ResultView.showLottoNum(lottoDto);
        ResultView.showLottoList(lottoDto);

        Reward reward = new Reward(InputView.getWinningNum());
        lottoGame.setLottoReward(reward);
        RewardDto rewardDto = lottoGame.createRewardDto(reward);
        ResultView.showWinStats(rewardDto);
        ResultView.showProfit(rewardDto);
    }
}
